// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.squareup.wire.protos.kotlin.map.Mappy in map.proto
package com.squareup.wire.protos.kotlin.map

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireField
import com.squareup.wire.`internal`.JvmField
import com.squareup.wire.`internal`.JvmSynthetic
import com.squareup.wire.`internal`.immutableCopyOf
import com.squareup.wire.`internal`.redactElements
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
import kotlin.lazy
import okio.ByteString

public class Mappy(
  things: Map<String, Thing> = emptyMap(),
  unknownFields: ByteString = ByteString.EMPTY,
) : Message<Mappy, Mappy.Builder>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 1,
    keyAdapter = "com.squareup.wire.ProtoAdapter#STRING",
    adapter = "com.squareup.wire.protos.kotlin.map.Thing#ADAPTER",
    schemaIndex = 0,
  )
  @JvmField
  public val things: Map<String, Thing> = immutableCopyOf("things", things)

  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.things = things
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Mappy) return false
    if (unknownFields != other.unknownFields) return false
    if (things != other.things) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + things.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (things.isNotEmpty()) result += """things=$things"""
    return result.joinToString(prefix = "Mappy{", separator = ", ", postfix = "}")
  }

  public fun copy(things: Map<String, Thing> = this.things, unknownFields: ByteString =
      this.unknownFields): Mappy = Mappy(things, unknownFields)

  public class Builder : Message.Builder<Mappy, Builder>() {
    @JvmField
    public var things: Map<String, Thing> = emptyMap()

    public fun things(things: Map<String, Thing>): Builder {
      this.things = things
      return this
    }

    override fun build(): Mappy = Mappy(
      things = things,
      unknownFields = buildUnknownFields()
    )
  }

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<Mappy> = object : ProtoAdapter<Mappy>(
      FieldEncoding.LENGTH_DELIMITED, 
      Mappy::class, 
      "type.googleapis.com/com.squareup.wire.protos.kotlin.map.Mappy", 
      PROTO_2, 
      null, 
      "map.proto"
    ) {
      private val thingsAdapter: ProtoAdapter<Map<String, Thing>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Thing.ADAPTER) }

      override fun encodedSize(`value`: Mappy): Int {
        var size = value.unknownFields.size
        size += thingsAdapter.encodedSizeWithTag(1, value.things)
        return size
      }

      override fun encode(writer: ProtoWriter, `value`: Mappy) {
        thingsAdapter.encodeWithTag(writer, 1, value.things)
        writer.writeBytes(value.unknownFields)
      }

      override fun encode(writer: ReverseProtoWriter, `value`: Mappy) {
        writer.writeBytes(value.unknownFields)
        thingsAdapter.encodeWithTag(writer, 1, value.things)
      }

      override fun decode(reader: ProtoReader): Mappy {
        val things = mutableMapOf<String, Thing>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> things.putAll(thingsAdapter.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return Mappy(
          things = things,
          unknownFields = unknownFields
        )
      }

      override fun redact(`value`: Mappy): Mappy = value.copy(
        things = value.things.redactElements(Thing.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L

    @JvmSynthetic
    public inline fun build(body: Builder.() -> Unit): Mappy = Builder().apply(body).build()
  }
}
