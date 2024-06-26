/*
 * Copyright (C) 2019 Square, Inc.
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
@file:Suppress("UsePropertyAccessSyntax")

package com.squareup.wire.schema

import com.squareup.wire.testing.add
import kotlin.test.assertFailsWith
import okio.Path
import okio.Path.Companion.toPath
import okio.fakefilesystem.FakeFileSystem
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LinkerTest {
  private val fs = FakeFileSystem().apply {
    if (Path.DIRECTORY_SEPARATOR == "\\") emulateWindows() else emulateUnix()
    createDirectories("proto-path".toPath())
  }

  @Test
  fun usedProtoPathFileIncludedInSchema() {
    fs.add(
      "source-path/a.proto",
      """
      |import "b.proto";
      |message A {
      |  optional B b = 1;
      |}
      """.trimMargin(),
    )
    fs.add(
      "proto-path/b.proto",
      """
      |message B {
      |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema()

    assertThat(schema.protoFiles.map { it.location }).containsExactly(
      Location.get("source-path", "a.proto"),
      Location.get("proto-path", "b.proto"),
      Location.get("google/protobuf/descriptor.proto"),
      Location.get("wire/extensions.proto"),
    )
  }

  @Test fun opaqueMessageDeclaredField() {
    fs.add(
      "source-path/cafe/cafe.proto",
      """
          |syntax = "proto2";
          |
          |package cafe;
          |
          |message CafeDrink {
          |  optional int32 size_ounces = 1;
          |  repeated EspressoShot shots = 2;
          |}
          |
          |message EspressoShot {
          |  optional Roast roast = 1;
          |  optional bool decaf = 2;
          |}
          |
          |enum Roast {
          |  MEDIUM = 1;
          |  DARK = 2;
          |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema(opaqueTypes = listOf(ProtoType.get("cafe.EspressoShot")))
    assertThat((schema.getType("cafe.CafeDrink") as MessageType).field("shots")!!.type!!)
      .isEqualTo(ProtoType.BYTES)
    assertThat(schema.protoFile("cafe/cafe.proto")!!.toSchema()).isEqualTo(
      """
        |// Proto schema formatted by Wire, do not edit.
        |// Source: cafe/cafe.proto
        |
        |syntax = "proto2";
        |
        |package cafe;
        |
        |message CafeDrink {
        |  optional int32 size_ounces = 1;
        |
        |  repeated bytes shots = 2;
        |}
        |
        |message EspressoShot {
        |  optional Roast roast = 1;
        |
        |  optional bool decaf = 2;
        |}
        |
        |enum Roast {
        |  MEDIUM = 1;
        |  DARK = 2;
        |}
    |
      """.trimMargin(),
    )
  }

  @Test fun enumsCannotBeOpaqued() {
    fs.add(
      "source-path/cafe/cafe.proto",
      """
          |syntax = "proto2";
          |
          |package cafe;
          |
          |message CafeDrink {
          |  optional int32 size_ounces = 1;
          |  repeated EspressoShot shots = 2;
          |}
          |
          |message EspressoShot {
          |  optional Roast roast = 1;
          |  optional bool decaf = 2;
          |}
          |
          |enum Roast {
          |  MEDIUM = 1;
          |  DARK = 2;
          |}
      """.trimMargin(),
    )
    val exception = assertFailsWith<SchemaException> {
      loadAndLinkSchema(opaqueTypes = listOf(ProtoType.get("cafe.Roast")))
    }
    assertThat(exception).hasMessageContaining(
      """
      |Enums like cafe.Roast cannot be opaqued
      |  for field roast (source-path/cafe/cafe.proto:11:3)
      |  in message cafe.EspressoShot (source-path/cafe/cafe.proto:10:1)
      """.trimMargin(),
    )
  }

  @Test fun opaqueExtensionField() {
    fs.add(
      "source-path/cafe/cafe.proto",
      """
          |syntax = "proto2";
          |
          |package cafe;
          |
          |message CafeDrink {
          |  optional int32 size_ounces = 1;
          |}
          |
          |extend CafeDrink {
          |  repeated EspressoShot shots = 2;
          |}
          |
          |message EspressoShot {
          |  optional Roast roast = 1;
          |  optional bool decaf = 2;
          |}
          |
          |enum Roast {
          |  MEDIUM = 1;
          |  DARK = 2;
          |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema(opaqueTypes = listOf(ProtoType.get("cafe.EspressoShot")))
    assertThat((schema.getType("cafe.CafeDrink") as MessageType).extensionField("cafe.shots")!!.type!!)
      .isEqualTo(ProtoType.BYTES)
    assertThat(schema.protoFile("cafe/cafe.proto")!!.toSchema()).isEqualTo(
      """
        |// Proto schema formatted by Wire, do not edit.
        |// Source: cafe/cafe.proto
        |
        |syntax = "proto2";
        |
        |package cafe;
        |
        |message CafeDrink {
        |  optional int32 size_ounces = 1;
        |}
        |
        |message EspressoShot {
        |  optional Roast roast = 1;
        |
        |  optional bool decaf = 2;
        |}
        |
        |enum Roast {
        |  MEDIUM = 1;
        |  DARK = 2;
        |}
        |
        |extend CafeDrink {
        |  repeated bytes shots = 2;
        |}
    |
      """.trimMargin(),
    )
  }

  @Test fun opaqueMultipleFields() {
    fs.add(
      "source-path/cafe/cafe.proto",
      """
          |syntax = "proto2";
          |
          |package cafe;
          |
          |message CafeDrink {
          |  optional int32 size_ounces = 1;
          |  repeated EspressoShot shots = 2;
          |}
          |
          |message EspressoShot {
          |  optional Roast roast = 1;
          |  optional bool decaf = 2;
          |}
          |
          |message Roast {
          |  optional int32 id = 1;
          |  optional string name = 2;
          |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema(
      opaqueTypes = listOf(
        ProtoType.get("cafe.EspressoShot"),
        ProtoType.get("cafe.Roast"),
      ),
    )
    assertThat((schema.getType("cafe.CafeDrink") as MessageType).field("shots")!!.type!!)
      .isEqualTo(ProtoType.BYTES)
    assertThat((schema.getType("cafe.EspressoShot") as MessageType).field("roast")!!.type!!)
      .isEqualTo(ProtoType.BYTES)
    assertThat(schema.protoFile("cafe/cafe.proto")!!.toSchema()).isEqualTo(
      """
        |// Proto schema formatted by Wire, do not edit.
        |// Source: cafe/cafe.proto
        |
        |syntax = "proto2";
        |
        |package cafe;
        |
        |message CafeDrink {
        |  optional int32 size_ounces = 1;
        |
        |  repeated bytes shots = 2;
        |}
        |
        |message EspressoShot {
        |  optional bytes roast = 1;
        |
        |  optional bool decaf = 2;
        |}
        |
        |message Roast {
        |  optional int32 id = 1;
        |
        |  optional string name = 2;
        |}
        |
      """.trimMargin(),
    )
  }

  @Test fun opaqueScalarTypeThrows() {
    fs.add(
      "source-path/cafe/cafe.proto",
      """
          |syntax = "proto2";
          |
          |package cafe;
          |
          |message CafeDrink {
          |  optional int32 size_ounces = 1;
          |}
      """.trimMargin(),
    )

    val exception = assertFailsWith<SchemaException> {
      loadAndLinkSchema(opaqueTypes = listOf(ProtoType.INT32))
    }
    assertThat(exception).hasMessageContaining(
      """
      |Scalar types like int32 cannot be opaqued
      |  for field size_ounces (source-path/cafe/cafe.proto:6:3)
      |  in message cafe.CafeDrink (source-path/cafe/cafe.proto:5:1)
      """.trimMargin(),
    )
  }

  @Test
  fun unusedProtoPathFileExcludedFromSchema() {
    fs.add(
      "source-path/a.proto",
      """
      |import "b.proto";
      |message A {
      |}
      """.trimMargin(),
    )
    fs.add(
      "proto-path/b.proto",
      """
      |message B {
      |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema()

    assertThat(schema.protoFiles.map { it.location }).containsExactly(
      Location.get("source-path", "a.proto"),
      Location.get("google/protobuf/descriptor.proto"),
      Location.get("wire/extensions.proto"),
    )
  }

  @Test
  fun onlyProtoPathTypesAreIncludedInSchema() {
    fs.add(
      "source-path/a.proto",
      """
      |import "b.proto";
      |message A {
      |  optional B b = 1;
      |}
      """.trimMargin(),
    )
    fs.add(
      "proto-path/b.proto",
      """
      |message B {
      |}
      |message C {
      |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema()

    assertThat(schema.getType("B")).isNotNull()
    assertThat(schema.getType("C")).isNull()
  }

  @Test
  fun protoPathMembersAreIncludedInSchemaIfTheyAreUsedInOptions() {
    fs.add(
      "source-path/a.proto",
      """
     |import "formatting_options.proto";
     |message A {
     |  optional string s = 1 [formatting_options.language.name = "English"];
     |}
      """.trimMargin(),
    )
    fs.add(
      "proto-path/formatting_options.proto",
      """
      |import "google/protobuf/descriptor.proto";
      |
      |message FormattingOptions {
      |  optional Language language = 1;
      |  optional StringCasing string_casing = 2;
      |}
      |
      |extend google.protobuf.FieldOptions {
      |  optional FormattingOptions formatting_options = 22001;
      |}
      |
      |message Language {
      |  optional string name = 1;
      |  optional string locale = 2;
      |}
      |
      |enum StringCasing {
      |  LOWER_CASE = 1;
      |  TITLE_CASE = 2;
      |  SENTENCE_CASE = 3;
      |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema()

    assertThat(schema.getType("FormattingOptions")).isNotNull()
    assertThat(schema.getType("Language")).isNotNull()
    assertThat(schema.getType("StringCasing")).isNotNull()

    assertThat(schema.getField("FormattingOptions", "language")).isNotNull()
    assertThat(schema.getField("FormattingOptions", "string_casing")).isNotNull()
    assertThat(schema.getField("Language", "name")).isNotNull()

    val fieldOptionsType = ProtoType.get("google.protobuf", "FieldOptions")
    assertThat(schema.getField(fieldOptionsType, "formatting_options")).isNotNull()
  }

  @Test
  fun protoPathMembersAreNotIncludedInSchemaIfTheyAreNotUsedInOptions() {
    fs.add(
      "source-path/a.proto",
      """
      |import "b.proto";
      |message A {
      |  optional B b = 1;
      |}
      """.trimMargin(),
    )
    fs.add(
      "proto-path/b.proto",
      """
      |message B {
      |  optional C c = 1;
      |}
      |message C {
      |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema()

    assertThat(schema.getType("B")).isNotNull()
    assertThat(schema.getType("C")).isNull()
    assertThat(schema.getField("B", "c")).isNull()
  }

  @Test
  fun javaPackageIsSetOnProtoPathFiles() {
    fs.add(
      "source-path/a.proto",
      """
      |import "b.proto";
      |message A {
      |  optional B b = 1;
      |}
      """.trimMargin(),
    )
    fs.add(
      "proto-path/b.proto",
      """
      |option java_package = "com.squareup.b";
      |message B {
      |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema()

    assertThat(schema.protoFile("b.proto")!!.javaPackage()).isEqualTo("com.squareup.b")
  }

  @Test
  fun descriptorProtoIsLinked() {
    fs.add(
      "source-path/a.proto",
      """
      |import "google/protobuf/descriptor.proto";
      |
      |enum Roshambo {
      |  ROCK = 1 [deprecated = true];
      |  SCISSORS = 2;
      |  PAPER = 3;
      |}
      """.trimMargin(),
    )
    val schema = loadAndLinkSchema()

    val enumValueDeprecated = schema.getField(Options.ENUM_VALUE_OPTIONS, "deprecated")
    assertThat(enumValueDeprecated!!.encodeMode).isNotNull()
  }

  private fun loadAndLinkSchema(
    opaqueTypes: List<ProtoType> = listOf(),
  ): Schema {
    val loader = SchemaLoader(fs)
    loader.opaqueTypes = opaqueTypes
    loader.initRoots(
      sourcePath = listOf(Location.get("source-path")),
      protoPath = listOf(Location.get("proto-path")),
    )
    return loader.loadSchema()
  }
}
