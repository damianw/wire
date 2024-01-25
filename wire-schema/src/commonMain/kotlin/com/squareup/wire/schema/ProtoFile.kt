/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire.schema

import com.squareup.wire.Syntax
import com.squareup.wire.schema.Extend.Companion.fromElements
import com.squareup.wire.schema.Service.Companion.fromElements
import com.squareup.wire.schema.Type.Companion.fromElements
import com.squareup.wire.schema.internal.parser.ProtoFileElement

data class ProtoFile(
  val location: Location,
  val imports: List<String>,
  val publicImports: List<String>,
  val packageName: String?,
  val types: List<Type>,
  val services: List<Service>,
  val extendList: List<Extend>,
  val options: Options,
  val syntax: Syntax?,
) {
  private var javaPackage: Any? = null
  private var wirePackage: Any? = null

  fun toElement(): ProtoFileElement {
    return ProtoFileElement(
      location,
      packageName,
      syntax,
      imports,
      publicImports,
      Type.toElements(types),
      Service.toElements(services),
      Extend.toElements(extendList),
      options.elements,
    )
  }

  /**
   * Returns the name of this proto file, like `simple_message` for
   * `squareup/protos/person/simple_message.proto`.
   */
  fun name(): String {
    var result = location.path

    val slashIndex = result.lastIndexOf('/')
    if (slashIndex != -1) {
      result = result.substring(slashIndex + 1)
    }

    if (result.endsWith(".proto")) {
      result = result.substring(0, result.length - ".proto".length)
    }

    return result
  }

  /**
   * Returns all types and subtypes which are found in the proto file.
   */
  fun typesAndNestedTypes(): List<Type> {
    val typesAndNestedTypes = mutableListOf<Type>()
    for (type in types) {
      typesAndNestedTypes.addAll(type.typesAndNestedTypes())
    }

    return typesAndNestedTypes
  }

  fun javaPackage(): String? {
    return javaPackage?.toString()
  }

  fun wirePackage(): String? {
    return wirePackage?.toString()
  }

  /**
   * Returns a new proto file that omits types, services, extensions, and options not in
   * `pruningRules`.
   */
  fun retainAll(schema: Schema, markSet: MarkSet): ProtoFile {
    val retainedTypes = types.mapNotNull { it.retainAll(schema, markSet) }

    val retainedServices = services.mapNotNull { it.retainAll(schema, markSet) }

    val retainedExtends = extendList.mapNotNull { it.retainAll(schema, markSet) }

    val retainedOptions = options.retainAll(schema, markSet)

    val result = ProtoFile(
      location, imports, publicImports, packageName, retainedTypes,
      retainedServices, retainedExtends, retainedOptions, syntax,
    )
    result.javaPackage = javaPackage
    result.wirePackage = wirePackage
    return result
  }

  /** Return a copy of this file with only the marked types. */
  fun retainLinked(linkedTypes: Set<ProtoType>, linkedFields: Set<Field>): ProtoFile {
    val retainedTypes = types.mapNotNull { it.retainLinked(linkedTypes, linkedFields) }
    val retainedExtends = extendList.mapNotNull { it.retainLinked(linkedFields) }

    // Other .proto files can't link to our services so strip them unconditionally.
    val retainedServices = emptyList<Service>()

    val retainedOptions = options.retainLinked()

    val result = ProtoFile(
      location, imports, publicImports, packageName, retainedTypes,
      retainedServices, retainedExtends, retainedOptions, syntax,
    )
    result.javaPackage = javaPackage
    result.wirePackage = wirePackage
    return result
  }

  private fun referencedTypes(schema: Schema): List<Type> {
    val types = typesAndNestedTypes()
    val messages = types.filterIsInstance<MessageType>()

    val messageTypes = messages
      .flatMap { it.fieldsAndOneOfFields }
      .mapNotNull { it.type }

    val messageOptions = messages.map { it.options }
    val fieldOptions = messages.flatMap { it.fieldsAndOneOfFields.map { it.options } }
    val oneOfOptions = messages.flatMap { it.oneOfs }.map { it.options }
    val optionTypes = (messageOptions + oneOfOptions + fieldOptions).flatMap { it.fields().asMap().keys }

    val rpcTypes = services
      .flatMap { service -> service.rpcs }
      .flatMap { rpc -> listOfNotNull(rpc.requestType, rpc.responseType) }

    return (messageTypes + optionTypes + rpcTypes).distinct().mapNotNull { schema.getType(it) }.toList()
  }

  /** Returns a new proto file that omits unnecessary imports. */
  fun retainImports(schema: Schema): ProtoFile {
    val referencedTypes = referencedTypes(schema)

    val typeLocations = referencedTypes.map { type -> type.location }

    val extensionLocations = referencedTypes
      .filterIsInstance<MessageType>()
      .flatMap { type -> type.extensionFields }
      .map { field -> field.location }

    val referencedImports = (typeLocations + extensionLocations).map { it.path }.toSet()

    val retainedImports = imports.filter { referencedImports.contains(it) }

    return if (imports.size != retainedImports.size) {
      val result = ProtoFile(
        location, retainedImports, publicImports, packageName, types, services,
        extendList, options, syntax,
      )
      result.javaPackage = javaPackage
      result.wirePackage = wirePackage
      result
    } else {
      this
    }
  }

  fun linkOptions(linker: Linker, validate: Boolean) {
    options.link(linker, location, validate)
    javaPackage = options.get(JAVA_PACKAGE)
    wirePackage = options.get(WIRE_PACKAGE)
  }

  override fun toString(): String {
    return location.path
  }

  fun toSchema(): String {
    return toElement().toSchema()
  }

  companion object {
    val JAVA_PACKAGE = ProtoMember.get(Options.FILE_OPTIONS, "java_package")
    val WIRE_PACKAGE = ProtoMember.get(Options.FILE_OPTIONS, "wire.wire_package")

    fun get(protoFileElement: ProtoFileElement): ProtoFile {
      val packageName = protoFileElement.packageName

      val syntax = protoFileElement.syntax ?: Syntax.PROTO_2
      val types = fromElements(packageName, protoFileElement.types, syntax)

      val services = fromElements(packageName, protoFileElement.services)

      val namespaces = when {
        packageName == null -> listOf()
        else -> listOf(packageName)
      }
      val wireExtends = fromElements(namespaces, protoFileElement.extendDeclarations)

      val options = Options(Options.FILE_OPTIONS, protoFileElement.options)

      return ProtoFile(
        protoFileElement.location, protoFileElement.imports,
        protoFileElement.publicImports, packageName, types, services, wireExtends, options,
        protoFileElement.syntax,
      )
    }

    private fun findProtoFile(protoFiles: List<ProtoFile>, path: String): ProtoFile? {
      return protoFiles.find { it.location.path == path }
    }
  }
}
