// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.flags.SomeResponse in service_kotlin_with_all_flags.proto
package com.squareup.wire.protos.kotlin.services.all_flags_on

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.`internal`.JvmField
import com.squareup.wire.`internal`.JvmSynthetic
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import okio.ByteString

public class SomeResponse private constructor(
  builder: Builder,
  unknownFields: ByteString = ByteString.EMPTY,
) : Message<SomeResponse, SomeResponse.Builder>(ADAPTER, unknownFields) {
  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is SomeResponse) return false
    if (unknownFields != other.unknownFields) return false
    return true
  }

  override fun hashCode(): Int = unknownFields.hashCode()

  override fun toString(): String = "SomeResponse{}"

  public class Builder : Message.Builder<SomeResponse, Builder>() {
    override fun build(): SomeResponse = SomeResponse(
      builder = this,
      unknownFields = buildUnknownFields()
    )
  }

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<SomeResponse> = object : ProtoAdapter<SomeResponse>(
      FieldEncoding.LENGTH_DELIMITED, 
      SomeResponse::class, 
      "type.googleapis.com/squareup.protos.kotlin.flags.SomeResponse", 
      PROTO_2, 
      null, 
      "service_kotlin_with_all_flags.proto"
    ) {
      override fun encodedSize(`value`: SomeResponse): Int {
        var size = value.unknownFields.size
        return size
      }

      override fun encode(writer: ProtoWriter, `value`: SomeResponse) {
        writer.writeBytes(value.unknownFields)
      }

      override fun encode(writer: ReverseProtoWriter, `value`: SomeResponse) {
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): SomeResponse {
        val builder = Builder()
        val unknownFields = reader.forEachTag(reader::readUnknownField)
        return SomeResponse(
          builder = builder,
          unknownFields = unknownFields
        )
      }

      override fun redact(`value`: SomeResponse): SomeResponse = SomeResponse(
        builder = value.newBuilder(),
        unknownFields = ByteString.EMPTY,
      )
    }

    private const val serialVersionUID: Long = 0L

    @JvmSynthetic
    public inline fun build(body: Builder.() -> Unit): SomeResponse = Builder().apply(body).build()
  }
}
