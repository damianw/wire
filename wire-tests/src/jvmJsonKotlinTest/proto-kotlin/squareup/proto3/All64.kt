// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.proto3.All64 in all64.proto
package squareup.proto3

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import com.squareup.wire.`internal`.JvmField
import com.squareup.wire.`internal`.JvmSynthetic
import com.squareup.wire.`internal`.checkElementsNotNull
import com.squareup.wire.`internal`.countNonNull
import com.squareup.wire.`internal`.immutableCopyOf
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.lazy
import okio.ByteString

public class All64(
  /**
   * Prefixing so the generated code doesn't rename it weirdly.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "myInt64",
    schemaIndex = 0,
  )
  @JvmField
  public val my_int64: Long = 0L,
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#UINT64",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "myUint64",
    schemaIndex = 1,
  )
  @JvmField
  public val my_uint64: Long = 0L,
  @field:WireField(
    tag = 3,
    adapter = "com.squareup.wire.ProtoAdapter#SINT64",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "mySint64",
    schemaIndex = 2,
  )
  @JvmField
  public val my_sint64: Long = 0L,
  @field:WireField(
    tag = 4,
    adapter = "com.squareup.wire.ProtoAdapter#FIXED64",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "myFixed64",
    schemaIndex = 3,
  )
  @JvmField
  public val my_fixed64: Long = 0L,
  @field:WireField(
    tag = 5,
    adapter = "com.squareup.wire.ProtoAdapter#SFIXED64",
    label = WireField.Label.OMIT_IDENTITY,
    jsonName = "mySfixed64",
    schemaIndex = 4,
  )
  @JvmField
  public val my_sfixed64: Long = 0L,
  rep_int64: List<Long> = emptyList(),
  rep_uint64: List<Long> = emptyList(),
  rep_sint64: List<Long> = emptyList(),
  rep_fixed64: List<Long> = emptyList(),
  rep_sfixed64: List<Long> = emptyList(),
  pack_int64: List<Long> = emptyList(),
  pack_uint64: List<Long> = emptyList(),
  pack_sint64: List<Long> = emptyList(),
  pack_fixed64: List<Long> = emptyList(),
  pack_sfixed64: List<Long> = emptyList(),
  @field:WireField(
    tag = 401,
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    jsonName = "oneofInt64",
    oneofName = "choice",
    schemaIndex = 15,
  )
  @JvmField
  public val oneof_int64: Long? = null,
  @field:WireField(
    tag = 402,
    adapter = "com.squareup.wire.ProtoAdapter#SFIXED64",
    jsonName = "oneofSfixed64",
    oneofName = "choice",
    schemaIndex = 16,
  )
  @JvmField
  public val oneof_sfixed64: Long? = null,
  map_int64_int64: Map<Long, Long> = emptyMap(),
  map_int64_uint64: Map<Long, Long> = emptyMap(),
  map_int64_sint64: Map<Long, Long> = emptyMap(),
  map_int64_fixed64: Map<Long, Long> = emptyMap(),
  map_int64_sfixed64: Map<Long, Long> = emptyMap(),
  unknownFields: ByteString = ByteString.EMPTY,
) : Message<All64, All64.Builder>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 201,
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    label = WireField.Label.REPEATED,
    jsonName = "repInt64",
    schemaIndex = 5,
  )
  @JvmField
  public val rep_int64: List<Long> = immutableCopyOf("rep_int64", rep_int64)

  @field:WireField(
    tag = 202,
    adapter = "com.squareup.wire.ProtoAdapter#UINT64",
    label = WireField.Label.REPEATED,
    jsonName = "repUint64",
    schemaIndex = 6,
  )
  @JvmField
  public val rep_uint64: List<Long> = immutableCopyOf("rep_uint64", rep_uint64)

  @field:WireField(
    tag = 203,
    adapter = "com.squareup.wire.ProtoAdapter#SINT64",
    label = WireField.Label.REPEATED,
    jsonName = "repSint64",
    schemaIndex = 7,
  )
  @JvmField
  public val rep_sint64: List<Long> = immutableCopyOf("rep_sint64", rep_sint64)

  @field:WireField(
    tag = 204,
    adapter = "com.squareup.wire.ProtoAdapter#FIXED64",
    label = WireField.Label.REPEATED,
    jsonName = "repFixed64",
    schemaIndex = 8,
  )
  @JvmField
  public val rep_fixed64: List<Long> = immutableCopyOf("rep_fixed64", rep_fixed64)

  @field:WireField(
    tag = 205,
    adapter = "com.squareup.wire.ProtoAdapter#SFIXED64",
    label = WireField.Label.REPEATED,
    jsonName = "repSfixed64",
    schemaIndex = 9,
  )
  @JvmField
  public val rep_sfixed64: List<Long> = immutableCopyOf("rep_sfixed64", rep_sfixed64)

  @field:WireField(
    tag = 301,
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    label = WireField.Label.PACKED,
    jsonName = "packInt64",
    schemaIndex = 10,
  )
  @JvmField
  public val pack_int64: List<Long> = immutableCopyOf("pack_int64", pack_int64)

  @field:WireField(
    tag = 302,
    adapter = "com.squareup.wire.ProtoAdapter#UINT64",
    label = WireField.Label.PACKED,
    jsonName = "packUint64",
    schemaIndex = 11,
  )
  @JvmField
  public val pack_uint64: List<Long> = immutableCopyOf("pack_uint64", pack_uint64)

  @field:WireField(
    tag = 303,
    adapter = "com.squareup.wire.ProtoAdapter#SINT64",
    label = WireField.Label.PACKED,
    jsonName = "packSint64",
    schemaIndex = 12,
  )
  @JvmField
  public val pack_sint64: List<Long> = immutableCopyOf("pack_sint64", pack_sint64)

  @field:WireField(
    tag = 304,
    adapter = "com.squareup.wire.ProtoAdapter#FIXED64",
    label = WireField.Label.PACKED,
    jsonName = "packFixed64",
    schemaIndex = 13,
  )
  @JvmField
  public val pack_fixed64: List<Long> = immutableCopyOf("pack_fixed64", pack_fixed64)

  @field:WireField(
    tag = 305,
    adapter = "com.squareup.wire.ProtoAdapter#SFIXED64",
    label = WireField.Label.PACKED,
    jsonName = "packSfixed64",
    schemaIndex = 14,
  )
  @JvmField
  public val pack_sfixed64: List<Long> = immutableCopyOf("pack_sfixed64", pack_sfixed64)

  @field:WireField(
    tag = 501,
    keyAdapter = "com.squareup.wire.ProtoAdapter#INT64",
    adapter = "com.squareup.wire.ProtoAdapter#INT64",
    jsonName = "mapInt64Int64",
    schemaIndex = 17,
  )
  @JvmField
  public val map_int64_int64: Map<Long, Long> = immutableCopyOf("map_int64_int64", map_int64_int64)

  @field:WireField(
    tag = 502,
    keyAdapter = "com.squareup.wire.ProtoAdapter#INT64",
    adapter = "com.squareup.wire.ProtoAdapter#UINT64",
    jsonName = "mapInt64Uint64",
    schemaIndex = 18,
  )
  @JvmField
  public val map_int64_uint64: Map<Long, Long> = immutableCopyOf("map_int64_uint64",
      map_int64_uint64)

  @field:WireField(
    tag = 503,
    keyAdapter = "com.squareup.wire.ProtoAdapter#INT64",
    adapter = "com.squareup.wire.ProtoAdapter#SINT64",
    jsonName = "mapInt64Sint64",
    schemaIndex = 19,
  )
  @JvmField
  public val map_int64_sint64: Map<Long, Long> = immutableCopyOf("map_int64_sint64",
      map_int64_sint64)

  @field:WireField(
    tag = 504,
    keyAdapter = "com.squareup.wire.ProtoAdapter#INT64",
    adapter = "com.squareup.wire.ProtoAdapter#FIXED64",
    jsonName = "mapInt64Fixed64",
    schemaIndex = 20,
  )
  @JvmField
  public val map_int64_fixed64: Map<Long, Long> = immutableCopyOf("map_int64_fixed64",
      map_int64_fixed64)

  @field:WireField(
    tag = 505,
    keyAdapter = "com.squareup.wire.ProtoAdapter#INT64",
    adapter = "com.squareup.wire.ProtoAdapter#SFIXED64",
    jsonName = "mapInt64Sfixed64",
    schemaIndex = 21,
  )
  @JvmField
  public val map_int64_sfixed64: Map<Long, Long> = immutableCopyOf("map_int64_sfixed64",
      map_int64_sfixed64)

  init {
    require(countNonNull(oneof_int64, oneof_sfixed64) <= 1) {
      "At most one of oneof_int64, oneof_sfixed64 may be non-null"
    }
  }

  override fun newBuilder(): Builder {
    val builder = Builder()
    builder.my_int64 = my_int64
    builder.my_uint64 = my_uint64
    builder.my_sint64 = my_sint64
    builder.my_fixed64 = my_fixed64
    builder.my_sfixed64 = my_sfixed64
    builder.rep_int64 = rep_int64
    builder.rep_uint64 = rep_uint64
    builder.rep_sint64 = rep_sint64
    builder.rep_fixed64 = rep_fixed64
    builder.rep_sfixed64 = rep_sfixed64
    builder.pack_int64 = pack_int64
    builder.pack_uint64 = pack_uint64
    builder.pack_sint64 = pack_sint64
    builder.pack_fixed64 = pack_fixed64
    builder.pack_sfixed64 = pack_sfixed64
    builder.oneof_int64 = oneof_int64
    builder.oneof_sfixed64 = oneof_sfixed64
    builder.map_int64_int64 = map_int64_int64
    builder.map_int64_uint64 = map_int64_uint64
    builder.map_int64_sint64 = map_int64_sint64
    builder.map_int64_fixed64 = map_int64_fixed64
    builder.map_int64_sfixed64 = map_int64_sfixed64
    builder.addUnknownFields(unknownFields)
    return builder
  }

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is All64) return false
    if (unknownFields != other.unknownFields) return false
    if (my_int64 != other.my_int64) return false
    if (my_uint64 != other.my_uint64) return false
    if (my_sint64 != other.my_sint64) return false
    if (my_fixed64 != other.my_fixed64) return false
    if (my_sfixed64 != other.my_sfixed64) return false
    if (rep_int64 != other.rep_int64) return false
    if (rep_uint64 != other.rep_uint64) return false
    if (rep_sint64 != other.rep_sint64) return false
    if (rep_fixed64 != other.rep_fixed64) return false
    if (rep_sfixed64 != other.rep_sfixed64) return false
    if (pack_int64 != other.pack_int64) return false
    if (pack_uint64 != other.pack_uint64) return false
    if (pack_sint64 != other.pack_sint64) return false
    if (pack_fixed64 != other.pack_fixed64) return false
    if (pack_sfixed64 != other.pack_sfixed64) return false
    if (oneof_int64 != other.oneof_int64) return false
    if (oneof_sfixed64 != other.oneof_sfixed64) return false
    if (map_int64_int64 != other.map_int64_int64) return false
    if (map_int64_uint64 != other.map_int64_uint64) return false
    if (map_int64_sint64 != other.map_int64_sint64) return false
    if (map_int64_fixed64 != other.map_int64_fixed64) return false
    if (map_int64_sfixed64 != other.map_int64_sfixed64) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + my_int64.hashCode()
      result = result * 37 + my_uint64.hashCode()
      result = result * 37 + my_sint64.hashCode()
      result = result * 37 + my_fixed64.hashCode()
      result = result * 37 + my_sfixed64.hashCode()
      result = result * 37 + rep_int64.hashCode()
      result = result * 37 + rep_uint64.hashCode()
      result = result * 37 + rep_sint64.hashCode()
      result = result * 37 + rep_fixed64.hashCode()
      result = result * 37 + rep_sfixed64.hashCode()
      result = result * 37 + pack_int64.hashCode()
      result = result * 37 + pack_uint64.hashCode()
      result = result * 37 + pack_sint64.hashCode()
      result = result * 37 + pack_fixed64.hashCode()
      result = result * 37 + pack_sfixed64.hashCode()
      result = result * 37 + (oneof_int64?.hashCode() ?: 0)
      result = result * 37 + (oneof_sfixed64?.hashCode() ?: 0)
      result = result * 37 + map_int64_int64.hashCode()
      result = result * 37 + map_int64_uint64.hashCode()
      result = result * 37 + map_int64_sint64.hashCode()
      result = result * 37 + map_int64_fixed64.hashCode()
      result = result * 37 + map_int64_sfixed64.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """my_int64=$my_int64"""
    result += """my_uint64=$my_uint64"""
    result += """my_sint64=$my_sint64"""
    result += """my_fixed64=$my_fixed64"""
    result += """my_sfixed64=$my_sfixed64"""
    if (rep_int64.isNotEmpty()) result += """rep_int64=$rep_int64"""
    if (rep_uint64.isNotEmpty()) result += """rep_uint64=$rep_uint64"""
    if (rep_sint64.isNotEmpty()) result += """rep_sint64=$rep_sint64"""
    if (rep_fixed64.isNotEmpty()) result += """rep_fixed64=$rep_fixed64"""
    if (rep_sfixed64.isNotEmpty()) result += """rep_sfixed64=$rep_sfixed64"""
    if (pack_int64.isNotEmpty()) result += """pack_int64=$pack_int64"""
    if (pack_uint64.isNotEmpty()) result += """pack_uint64=$pack_uint64"""
    if (pack_sint64.isNotEmpty()) result += """pack_sint64=$pack_sint64"""
    if (pack_fixed64.isNotEmpty()) result += """pack_fixed64=$pack_fixed64"""
    if (pack_sfixed64.isNotEmpty()) result += """pack_sfixed64=$pack_sfixed64"""
    if (oneof_int64 != null) result += """oneof_int64=$oneof_int64"""
    if (oneof_sfixed64 != null) result += """oneof_sfixed64=$oneof_sfixed64"""
    if (map_int64_int64.isNotEmpty()) result += """map_int64_int64=$map_int64_int64"""
    if (map_int64_uint64.isNotEmpty()) result += """map_int64_uint64=$map_int64_uint64"""
    if (map_int64_sint64.isNotEmpty()) result += """map_int64_sint64=$map_int64_sint64"""
    if (map_int64_fixed64.isNotEmpty()) result += """map_int64_fixed64=$map_int64_fixed64"""
    if (map_int64_sfixed64.isNotEmpty()) result += """map_int64_sfixed64=$map_int64_sfixed64"""
    return result.joinToString(prefix = "All64{", separator = ", ", postfix = "}")
  }

  public fun copy(
    my_int64: Long = this.my_int64,
    my_uint64: Long = this.my_uint64,
    my_sint64: Long = this.my_sint64,
    my_fixed64: Long = this.my_fixed64,
    my_sfixed64: Long = this.my_sfixed64,
    rep_int64: List<Long> = this.rep_int64,
    rep_uint64: List<Long> = this.rep_uint64,
    rep_sint64: List<Long> = this.rep_sint64,
    rep_fixed64: List<Long> = this.rep_fixed64,
    rep_sfixed64: List<Long> = this.rep_sfixed64,
    pack_int64: List<Long> = this.pack_int64,
    pack_uint64: List<Long> = this.pack_uint64,
    pack_sint64: List<Long> = this.pack_sint64,
    pack_fixed64: List<Long> = this.pack_fixed64,
    pack_sfixed64: List<Long> = this.pack_sfixed64,
    oneof_int64: Long? = this.oneof_int64,
    oneof_sfixed64: Long? = this.oneof_sfixed64,
    map_int64_int64: Map<Long, Long> = this.map_int64_int64,
    map_int64_uint64: Map<Long, Long> = this.map_int64_uint64,
    map_int64_sint64: Map<Long, Long> = this.map_int64_sint64,
    map_int64_fixed64: Map<Long, Long> = this.map_int64_fixed64,
    map_int64_sfixed64: Map<Long, Long> = this.map_int64_sfixed64,
    unknownFields: ByteString = this.unknownFields,
  ): All64 = All64(my_int64, my_uint64, my_sint64, my_fixed64, my_sfixed64, rep_int64, rep_uint64,
      rep_sint64, rep_fixed64, rep_sfixed64, pack_int64, pack_uint64, pack_sint64, pack_fixed64,
      pack_sfixed64, oneof_int64, oneof_sfixed64, map_int64_int64, map_int64_uint64,
      map_int64_sint64, map_int64_fixed64, map_int64_sfixed64, unknownFields)

  public class Builder : Message.Builder<All64, Builder>() {
    @JvmField
    public var my_int64: Long = 0L

    @JvmField
    public var my_uint64: Long = 0L

    @JvmField
    public var my_sint64: Long = 0L

    @JvmField
    public var my_fixed64: Long = 0L

    @JvmField
    public var my_sfixed64: Long = 0L

    @JvmField
    public var rep_int64: List<Long> = emptyList()

    @JvmField
    public var rep_uint64: List<Long> = emptyList()

    @JvmField
    public var rep_sint64: List<Long> = emptyList()

    @JvmField
    public var rep_fixed64: List<Long> = emptyList()

    @JvmField
    public var rep_sfixed64: List<Long> = emptyList()

    @JvmField
    public var pack_int64: List<Long> = emptyList()

    @JvmField
    public var pack_uint64: List<Long> = emptyList()

    @JvmField
    public var pack_sint64: List<Long> = emptyList()

    @JvmField
    public var pack_fixed64: List<Long> = emptyList()

    @JvmField
    public var pack_sfixed64: List<Long> = emptyList()

    @JvmField
    public var oneof_int64: Long? = null

    @JvmField
    public var oneof_sfixed64: Long? = null

    @JvmField
    public var map_int64_int64: Map<Long, Long> = emptyMap()

    @JvmField
    public var map_int64_uint64: Map<Long, Long> = emptyMap()

    @JvmField
    public var map_int64_sint64: Map<Long, Long> = emptyMap()

    @JvmField
    public var map_int64_fixed64: Map<Long, Long> = emptyMap()

    @JvmField
    public var map_int64_sfixed64: Map<Long, Long> = emptyMap()

    /**
     * Prefixing so the generated code doesn't rename it weirdly.
     */
    public fun my_int64(my_int64: Long): Builder {
      this.my_int64 = my_int64
      return this
    }

    public fun my_uint64(my_uint64: Long): Builder {
      this.my_uint64 = my_uint64
      return this
    }

    public fun my_sint64(my_sint64: Long): Builder {
      this.my_sint64 = my_sint64
      return this
    }

    public fun my_fixed64(my_fixed64: Long): Builder {
      this.my_fixed64 = my_fixed64
      return this
    }

    public fun my_sfixed64(my_sfixed64: Long): Builder {
      this.my_sfixed64 = my_sfixed64
      return this
    }

    public fun rep_int64(rep_int64: List<Long>): Builder {
      checkElementsNotNull(rep_int64)
      this.rep_int64 = rep_int64
      return this
    }

    public fun rep_uint64(rep_uint64: List<Long>): Builder {
      checkElementsNotNull(rep_uint64)
      this.rep_uint64 = rep_uint64
      return this
    }

    public fun rep_sint64(rep_sint64: List<Long>): Builder {
      checkElementsNotNull(rep_sint64)
      this.rep_sint64 = rep_sint64
      return this
    }

    public fun rep_fixed64(rep_fixed64: List<Long>): Builder {
      checkElementsNotNull(rep_fixed64)
      this.rep_fixed64 = rep_fixed64
      return this
    }

    public fun rep_sfixed64(rep_sfixed64: List<Long>): Builder {
      checkElementsNotNull(rep_sfixed64)
      this.rep_sfixed64 = rep_sfixed64
      return this
    }

    public fun pack_int64(pack_int64: List<Long>): Builder {
      checkElementsNotNull(pack_int64)
      this.pack_int64 = pack_int64
      return this
    }

    public fun pack_uint64(pack_uint64: List<Long>): Builder {
      checkElementsNotNull(pack_uint64)
      this.pack_uint64 = pack_uint64
      return this
    }

    public fun pack_sint64(pack_sint64: List<Long>): Builder {
      checkElementsNotNull(pack_sint64)
      this.pack_sint64 = pack_sint64
      return this
    }

    public fun pack_fixed64(pack_fixed64: List<Long>): Builder {
      checkElementsNotNull(pack_fixed64)
      this.pack_fixed64 = pack_fixed64
      return this
    }

    public fun pack_sfixed64(pack_sfixed64: List<Long>): Builder {
      checkElementsNotNull(pack_sfixed64)
      this.pack_sfixed64 = pack_sfixed64
      return this
    }

    public fun map_int64_int64(map_int64_int64: Map<Long, Long>): Builder {
      this.map_int64_int64 = map_int64_int64
      return this
    }

    public fun map_int64_uint64(map_int64_uint64: Map<Long, Long>): Builder {
      this.map_int64_uint64 = map_int64_uint64
      return this
    }

    public fun map_int64_sint64(map_int64_sint64: Map<Long, Long>): Builder {
      this.map_int64_sint64 = map_int64_sint64
      return this
    }

    public fun map_int64_fixed64(map_int64_fixed64: Map<Long, Long>): Builder {
      this.map_int64_fixed64 = map_int64_fixed64
      return this
    }

    public fun map_int64_sfixed64(map_int64_sfixed64: Map<Long, Long>): Builder {
      this.map_int64_sfixed64 = map_int64_sfixed64
      return this
    }

    public fun oneof_int64(oneof_int64: Long?): Builder {
      this.oneof_int64 = oneof_int64
      this.oneof_sfixed64 = null
      return this
    }

    public fun oneof_sfixed64(oneof_sfixed64: Long?): Builder {
      this.oneof_sfixed64 = oneof_sfixed64
      this.oneof_int64 = null
      return this
    }

    override fun build(): All64 = All64(
      my_int64 = my_int64,
      my_uint64 = my_uint64,
      my_sint64 = my_sint64,
      my_fixed64 = my_fixed64,
      my_sfixed64 = my_sfixed64,
      rep_int64 = rep_int64,
      rep_uint64 = rep_uint64,
      rep_sint64 = rep_sint64,
      rep_fixed64 = rep_fixed64,
      rep_sfixed64 = rep_sfixed64,
      pack_int64 = pack_int64,
      pack_uint64 = pack_uint64,
      pack_sint64 = pack_sint64,
      pack_fixed64 = pack_fixed64,
      pack_sfixed64 = pack_sfixed64,
      oneof_int64 = oneof_int64,
      oneof_sfixed64 = oneof_sfixed64,
      map_int64_int64 = map_int64_int64,
      map_int64_uint64 = map_int64_uint64,
      map_int64_sint64 = map_int64_sint64,
      map_int64_fixed64 = map_int64_fixed64,
      map_int64_sfixed64 = map_int64_sfixed64,
      unknownFields = buildUnknownFields()
    )
  }

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<All64> = object : ProtoAdapter<All64>(
      FieldEncoding.LENGTH_DELIMITED, 
      All64::class, 
      "type.googleapis.com/squareup.proto3.All64", 
      PROTO_3, 
      null, 
      "all64.proto"
    ) {
      private val map_int64_int64Adapter: ProtoAdapter<Map<Long, Long>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ProtoAdapter.INT64) }

      private val map_int64_uint64Adapter: ProtoAdapter<Map<Long, Long>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ProtoAdapter.UINT64) }

      private val map_int64_sint64Adapter: ProtoAdapter<Map<Long, Long>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ProtoAdapter.SINT64) }

      private val map_int64_fixed64Adapter: ProtoAdapter<Map<Long, Long>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ProtoAdapter.FIXED64) }

      private val map_int64_sfixed64Adapter: ProtoAdapter<Map<Long, Long>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, ProtoAdapter.SFIXED64) }

      override fun encodedSize(`value`: All64): Int {
        var size = value.unknownFields.size
        if (value.my_int64 != 0L) size += ProtoAdapter.INT64.encodedSizeWithTag(1, value.my_int64)
        if (value.my_uint64 != 0L) size += ProtoAdapter.UINT64.encodedSizeWithTag(2,
            value.my_uint64)
        if (value.my_sint64 != 0L) size += ProtoAdapter.SINT64.encodedSizeWithTag(3,
            value.my_sint64)
        if (value.my_fixed64 != 0L) size += ProtoAdapter.FIXED64.encodedSizeWithTag(4,
            value.my_fixed64)
        if (value.my_sfixed64 != 0L) size += ProtoAdapter.SFIXED64.encodedSizeWithTag(5,
            value.my_sfixed64)
        size += ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(201, value.rep_int64)
        size += ProtoAdapter.UINT64.asRepeated().encodedSizeWithTag(202, value.rep_uint64)
        size += ProtoAdapter.SINT64.asRepeated().encodedSizeWithTag(203, value.rep_sint64)
        size += ProtoAdapter.FIXED64.asRepeated().encodedSizeWithTag(204, value.rep_fixed64)
        size += ProtoAdapter.SFIXED64.asRepeated().encodedSizeWithTag(205, value.rep_sfixed64)
        size += ProtoAdapter.INT64.asPacked().encodedSizeWithTag(301, value.pack_int64)
        size += ProtoAdapter.UINT64.asPacked().encodedSizeWithTag(302, value.pack_uint64)
        size += ProtoAdapter.SINT64.asPacked().encodedSizeWithTag(303, value.pack_sint64)
        size += ProtoAdapter.FIXED64.asPacked().encodedSizeWithTag(304, value.pack_fixed64)
        size += ProtoAdapter.SFIXED64.asPacked().encodedSizeWithTag(305, value.pack_sfixed64)
        size += ProtoAdapter.INT64.encodedSizeWithTag(401, value.oneof_int64)
        size += ProtoAdapter.SFIXED64.encodedSizeWithTag(402, value.oneof_sfixed64)
        size += map_int64_int64Adapter.encodedSizeWithTag(501, value.map_int64_int64)
        size += map_int64_uint64Adapter.encodedSizeWithTag(502, value.map_int64_uint64)
        size += map_int64_sint64Adapter.encodedSizeWithTag(503, value.map_int64_sint64)
        size += map_int64_fixed64Adapter.encodedSizeWithTag(504, value.map_int64_fixed64)
        size += map_int64_sfixed64Adapter.encodedSizeWithTag(505, value.map_int64_sfixed64)
        return size
      }

      override fun encode(writer: ProtoWriter, `value`: All64) {
        if (value.my_int64 != 0L) ProtoAdapter.INT64.encodeWithTag(writer, 1, value.my_int64)
        if (value.my_uint64 != 0L) ProtoAdapter.UINT64.encodeWithTag(writer, 2, value.my_uint64)
        if (value.my_sint64 != 0L) ProtoAdapter.SINT64.encodeWithTag(writer, 3, value.my_sint64)
        if (value.my_fixed64 != 0L) ProtoAdapter.FIXED64.encodeWithTag(writer, 4, value.my_fixed64)
        if (value.my_sfixed64 != 0L) ProtoAdapter.SFIXED64.encodeWithTag(writer, 5,
            value.my_sfixed64)
        ProtoAdapter.INT64.asRepeated().encodeWithTag(writer, 201, value.rep_int64)
        ProtoAdapter.UINT64.asRepeated().encodeWithTag(writer, 202, value.rep_uint64)
        ProtoAdapter.SINT64.asRepeated().encodeWithTag(writer, 203, value.rep_sint64)
        ProtoAdapter.FIXED64.asRepeated().encodeWithTag(writer, 204, value.rep_fixed64)
        ProtoAdapter.SFIXED64.asRepeated().encodeWithTag(writer, 205, value.rep_sfixed64)
        ProtoAdapter.INT64.asPacked().encodeWithTag(writer, 301, value.pack_int64)
        ProtoAdapter.UINT64.asPacked().encodeWithTag(writer, 302, value.pack_uint64)
        ProtoAdapter.SINT64.asPacked().encodeWithTag(writer, 303, value.pack_sint64)
        ProtoAdapter.FIXED64.asPacked().encodeWithTag(writer, 304, value.pack_fixed64)
        ProtoAdapter.SFIXED64.asPacked().encodeWithTag(writer, 305, value.pack_sfixed64)
        map_int64_int64Adapter.encodeWithTag(writer, 501, value.map_int64_int64)
        map_int64_uint64Adapter.encodeWithTag(writer, 502, value.map_int64_uint64)
        map_int64_sint64Adapter.encodeWithTag(writer, 503, value.map_int64_sint64)
        map_int64_fixed64Adapter.encodeWithTag(writer, 504, value.map_int64_fixed64)
        map_int64_sfixed64Adapter.encodeWithTag(writer, 505, value.map_int64_sfixed64)
        ProtoAdapter.INT64.encodeWithTag(writer, 401, value.oneof_int64)
        ProtoAdapter.SFIXED64.encodeWithTag(writer, 402, value.oneof_sfixed64)
        writer.writeBytes(value.unknownFields)
      }

      override fun encode(writer: ReverseProtoWriter, `value`: All64) {
        writer.writeBytes(value.unknownFields)
        ProtoAdapter.SFIXED64.encodeWithTag(writer, 402, value.oneof_sfixed64)
        ProtoAdapter.INT64.encodeWithTag(writer, 401, value.oneof_int64)
        map_int64_sfixed64Adapter.encodeWithTag(writer, 505, value.map_int64_sfixed64)
        map_int64_fixed64Adapter.encodeWithTag(writer, 504, value.map_int64_fixed64)
        map_int64_sint64Adapter.encodeWithTag(writer, 503, value.map_int64_sint64)
        map_int64_uint64Adapter.encodeWithTag(writer, 502, value.map_int64_uint64)
        map_int64_int64Adapter.encodeWithTag(writer, 501, value.map_int64_int64)
        ProtoAdapter.SFIXED64.asPacked().encodeWithTag(writer, 305, value.pack_sfixed64)
        ProtoAdapter.FIXED64.asPacked().encodeWithTag(writer, 304, value.pack_fixed64)
        ProtoAdapter.SINT64.asPacked().encodeWithTag(writer, 303, value.pack_sint64)
        ProtoAdapter.UINT64.asPacked().encodeWithTag(writer, 302, value.pack_uint64)
        ProtoAdapter.INT64.asPacked().encodeWithTag(writer, 301, value.pack_int64)
        ProtoAdapter.SFIXED64.asRepeated().encodeWithTag(writer, 205, value.rep_sfixed64)
        ProtoAdapter.FIXED64.asRepeated().encodeWithTag(writer, 204, value.rep_fixed64)
        ProtoAdapter.SINT64.asRepeated().encodeWithTag(writer, 203, value.rep_sint64)
        ProtoAdapter.UINT64.asRepeated().encodeWithTag(writer, 202, value.rep_uint64)
        ProtoAdapter.INT64.asRepeated().encodeWithTag(writer, 201, value.rep_int64)
        if (value.my_sfixed64 != 0L) ProtoAdapter.SFIXED64.encodeWithTag(writer, 5,
            value.my_sfixed64)
        if (value.my_fixed64 != 0L) ProtoAdapter.FIXED64.encodeWithTag(writer, 4, value.my_fixed64)
        if (value.my_sint64 != 0L) ProtoAdapter.SINT64.encodeWithTag(writer, 3, value.my_sint64)
        if (value.my_uint64 != 0L) ProtoAdapter.UINT64.encodeWithTag(writer, 2, value.my_uint64)
        if (value.my_int64 != 0L) ProtoAdapter.INT64.encodeWithTag(writer, 1, value.my_int64)
      }

      override fun decode(reader: ProtoReader): All64 {
        var my_int64: Long = 0L
        var my_uint64: Long = 0L
        var my_sint64: Long = 0L
        var my_fixed64: Long = 0L
        var my_sfixed64: Long = 0L
        val rep_int64 = mutableListOf<Long>()
        val rep_uint64 = mutableListOf<Long>()
        val rep_sint64 = mutableListOf<Long>()
        val rep_fixed64 = mutableListOf<Long>()
        val rep_sfixed64 = mutableListOf<Long>()
        var pack_int64: MutableList<Long>? = null
        var pack_uint64: MutableList<Long>? = null
        var pack_sint64: MutableList<Long>? = null
        var pack_fixed64: MutableList<Long>? = null
        var pack_sfixed64: MutableList<Long>? = null
        var oneof_int64: Long? = null
        var oneof_sfixed64: Long? = null
        val map_int64_int64 = mutableMapOf<Long, Long>()
        val map_int64_uint64 = mutableMapOf<Long, Long>()
        val map_int64_sint64 = mutableMapOf<Long, Long>()
        val map_int64_fixed64 = mutableMapOf<Long, Long>()
        val map_int64_sfixed64 = mutableMapOf<Long, Long>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> my_int64 = ProtoAdapter.INT64.decode(reader)
            2 -> my_uint64 = ProtoAdapter.UINT64.decode(reader)
            3 -> my_sint64 = ProtoAdapter.SINT64.decode(reader)
            4 -> my_fixed64 = ProtoAdapter.FIXED64.decode(reader)
            5 -> my_sfixed64 = ProtoAdapter.SFIXED64.decode(reader)
            201 -> rep_int64.add(ProtoAdapter.INT64.decode(reader))
            202 -> rep_uint64.add(ProtoAdapter.UINT64.decode(reader))
            203 -> rep_sint64.add(ProtoAdapter.SINT64.decode(reader))
            204 -> rep_fixed64.add(ProtoAdapter.FIXED64.decode(reader))
            205 -> rep_sfixed64.add(ProtoAdapter.SFIXED64.decode(reader))
            301 -> {
              if (pack_int64 == null) {
                val minimumByteSize = 1
                val initialCapacity = (reader.nextFieldMinLengthInBytes() / minimumByteSize)
                  .coerceAtMost(Int.MAX_VALUE.toLong())
                  .toInt()
                pack_int64 = ArrayList(initialCapacity)
              }
              pack_int64!!.add(ProtoAdapter.INT64.decode(reader))
            }
            302 -> {
              if (pack_uint64 == null) {
                val minimumByteSize = 1
                val initialCapacity = (reader.nextFieldMinLengthInBytes() / minimumByteSize)
                  .coerceAtMost(Int.MAX_VALUE.toLong())
                  .toInt()
                pack_uint64 = ArrayList(initialCapacity)
              }
              pack_uint64!!.add(ProtoAdapter.UINT64.decode(reader))
            }
            303 -> {
              if (pack_sint64 == null) {
                val minimumByteSize = 1
                val initialCapacity = (reader.nextFieldMinLengthInBytes() / minimumByteSize)
                  .coerceAtMost(Int.MAX_VALUE.toLong())
                  .toInt()
                pack_sint64 = ArrayList(initialCapacity)
              }
              pack_sint64!!.add(ProtoAdapter.SINT64.decode(reader))
            }
            304 -> {
              if (pack_fixed64 == null) {
                val minimumByteSize = 8
                val initialCapacity = (reader.nextFieldMinLengthInBytes() / minimumByteSize)
                  .coerceAtMost(Int.MAX_VALUE.toLong())
                  .toInt()
                pack_fixed64 = ArrayList(initialCapacity)
              }
              pack_fixed64!!.add(ProtoAdapter.FIXED64.decode(reader))
            }
            305 -> {
              if (pack_sfixed64 == null) {
                val minimumByteSize = 8
                val initialCapacity = (reader.nextFieldMinLengthInBytes() / minimumByteSize)
                  .coerceAtMost(Int.MAX_VALUE.toLong())
                  .toInt()
                pack_sfixed64 = ArrayList(initialCapacity)
              }
              pack_sfixed64!!.add(ProtoAdapter.SFIXED64.decode(reader))
            }
            401 -> oneof_int64 = ProtoAdapter.INT64.decode(reader)
            402 -> oneof_sfixed64 = ProtoAdapter.SFIXED64.decode(reader)
            501 -> map_int64_int64.putAll(map_int64_int64Adapter.decode(reader))
            502 -> map_int64_uint64.putAll(map_int64_uint64Adapter.decode(reader))
            503 -> map_int64_sint64.putAll(map_int64_sint64Adapter.decode(reader))
            504 -> map_int64_fixed64.putAll(map_int64_fixed64Adapter.decode(reader))
            505 -> map_int64_sfixed64.putAll(map_int64_sfixed64Adapter.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return All64(
          my_int64 = my_int64,
          my_uint64 = my_uint64,
          my_sint64 = my_sint64,
          my_fixed64 = my_fixed64,
          my_sfixed64 = my_sfixed64,
          rep_int64 = rep_int64,
          rep_uint64 = rep_uint64,
          rep_sint64 = rep_sint64,
          rep_fixed64 = rep_fixed64,
          rep_sfixed64 = rep_sfixed64,
          pack_int64 = pack_int64 ?: listOf(),
          pack_uint64 = pack_uint64 ?: listOf(),
          pack_sint64 = pack_sint64 ?: listOf(),
          pack_fixed64 = pack_fixed64 ?: listOf(),
          pack_sfixed64 = pack_sfixed64 ?: listOf(),
          oneof_int64 = oneof_int64,
          oneof_sfixed64 = oneof_sfixed64,
          map_int64_int64 = map_int64_int64,
          map_int64_uint64 = map_int64_uint64,
          map_int64_sint64 = map_int64_sint64,
          map_int64_fixed64 = map_int64_fixed64,
          map_int64_sfixed64 = map_int64_sfixed64,
          unknownFields = unknownFields
        )
      }

      override fun redact(`value`: All64): All64 = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L

    @JvmSynthetic
    public inline fun build(body: Builder.() -> Unit): All64 = Builder().apply(body).build()
  }
}
