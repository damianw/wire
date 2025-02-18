// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.proto2.keywords.KeywordKotlin in keyword_kotlin.proto
@file:Suppress(
  "DEPRECATION",
  "RUNTIME_ANNOTATION_NOT_SUPPORTED",
)

package squareup.proto2.keywords

import com.squareup.wire.EnumAdapter
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireEnum
import com.squareup.wire.WireEnumConstant
import com.squareup.wire.WireField
import com.squareup.wire.`internal`.JvmField
import com.squareup.wire.`internal`.JvmStatic
import com.squareup.wire.`internal`.immutableCopyOf
import com.squareup.wire.`internal`.missingRequiredFields
import com.squareup.wire.`internal`.sanitize
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.lazy
import okio.ByteString

public class KeywordKotlin(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    schemaIndex = 0,
  )
  public val `object`: String? = null,
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#INT32",
    label = WireField.Label.REQUIRED,
    schemaIndex = 1,
  )
  public val `when`: Int,
  `fun`: Map<String, String> = emptyMap(),
  `return`: List<Boolean> = emptyList(),
  enums: List<KeywordKotlinEnum> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY,
) : Message<KeywordKotlin, Nothing>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 3,
    keyAdapter = "com.squareup.wire.ProtoAdapter#STRING",
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    schemaIndex = 2,
  )
  public val `fun`: Map<String, String> = immutableCopyOf("fun", `fun`)

  @field:WireField(
    tag = 4,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
    label = WireField.Label.REPEATED,
    schemaIndex = 3,
  )
  public val `return`: List<Boolean> = immutableCopyOf("return", `return`)

  @field:WireField(
    tag = 5,
    adapter = "squareup.proto2.keywords.KeywordKotlin${'$'}KeywordKotlinEnum#ADAPTER",
    label = WireField.Label.REPEATED,
    schemaIndex = 4,
  )
  public val enums: List<KeywordKotlinEnum> = immutableCopyOf("enums", enums)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  override fun newBuilder(): Nothing = throw AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is KeywordKotlin) return false
    if (unknownFields != other.unknownFields) return false
    if (`object` != other.`object`) return false
    if (`when` != other.`when`) return false
    if (`fun` != other.`fun`) return false
    if (`return` != other.`return`) return false
    if (enums != other.enums) return false
    return true
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + (`object`?.hashCode() ?: 0)
      result = result * 37 + `when`.hashCode()
      result = result * 37 + `fun`.hashCode()
      result = result * 37 + `return`.hashCode()
      result = result * 37 + enums.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    if (`object` != null) result += """object=${sanitize(`object`)}"""
    result += """when=$`when`"""
    if (`fun`.isNotEmpty()) result += """fun=$`fun`"""
    if (`return`.isNotEmpty()) result += """return=$`return`"""
    if (enums.isNotEmpty()) result += """enums=$enums"""
    return result.joinToString(prefix = "KeywordKotlin{", separator = ", ", postfix = "}")
  }

  public fun copy(
    `object`: String? = this.`object`,
    `when`: Int = this.`when`,
    `fun`: Map<String, String> = this.`fun`,
    `return`: List<Boolean> = this.`return`,
    enums: List<KeywordKotlinEnum> = this.enums,
    unknownFields: ByteString = this.unknownFields,
  ): KeywordKotlin = KeywordKotlin(`object`, `when`, `fun`, `return`, enums, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<KeywordKotlin> = object : ProtoAdapter<KeywordKotlin>(
      FieldEncoding.LENGTH_DELIMITED, 
      KeywordKotlin::class, 
      "type.googleapis.com/squareup.proto2.keywords.KeywordKotlin", 
      PROTO_2, 
      null, 
      "keyword_kotlin.proto"
    ) {
      private val funAdapter: ProtoAdapter<Map<String, String>> by
          lazy { ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING) }

      override fun encodedSize(`value`: KeywordKotlin): Int {
        var size = value.unknownFields.size
        size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.`object`)
        size += ProtoAdapter.INT32.encodedSizeWithTag(2, value.`when`)
        size += funAdapter.encodedSizeWithTag(3, value.`fun`)
        size += ProtoAdapter.BOOL.asRepeated().encodedSizeWithTag(4, value.`return`)
        size += KeywordKotlinEnum.ADAPTER.asRepeated().encodedSizeWithTag(5, value.enums)
        return size
      }

      override fun encode(writer: ProtoWriter, `value`: KeywordKotlin) {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.`object`)
        ProtoAdapter.INT32.encodeWithTag(writer, 2, value.`when`)
        funAdapter.encodeWithTag(writer, 3, value.`fun`)
        ProtoAdapter.BOOL.asRepeated().encodeWithTag(writer, 4, value.`return`)
        KeywordKotlinEnum.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.enums)
        writer.writeBytes(value.unknownFields)
      }

      override fun encode(writer: ReverseProtoWriter, `value`: KeywordKotlin) {
        writer.writeBytes(value.unknownFields)
        KeywordKotlinEnum.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.enums)
        ProtoAdapter.BOOL.asRepeated().encodeWithTag(writer, 4, value.`return`)
        funAdapter.encodeWithTag(writer, 3, value.`fun`)
        ProtoAdapter.INT32.encodeWithTag(writer, 2, value.`when`)
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.`object`)
      }

      override fun decode(reader: ProtoReader): KeywordKotlin {
        var `object`: String? = null
        var `when`: Int? = null
        val `fun` = mutableMapOf<String, String>()
        val `return` = mutableListOf<Boolean>()
        val enums = mutableListOf<KeywordKotlinEnum>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> `object` = ProtoAdapter.STRING.decode(reader)
            2 -> `when` = ProtoAdapter.INT32.decode(reader)
            3 -> `fun`.putAll(funAdapter.decode(reader))
            4 -> `return`.add(ProtoAdapter.BOOL.decode(reader))
            5 -> try {
              KeywordKotlinEnum.ADAPTER.tryDecode(reader, enums)
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
              reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }
            else -> reader.readUnknownField(tag)
          }
        }
        return KeywordKotlin(
          `object` = `object`,
          `when` = `when` ?: throw missingRequiredFields(`when`, "when"),
          `fun` = `fun`,
          `return` = `return`,
          enums = enums,
          unknownFields = unknownFields
        )
      }

      override fun redact(`value`: KeywordKotlin): KeywordKotlin = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }

  public enum class KeywordKotlinEnum(
    override val `value`: Int,
  ) : WireEnum {
    `object`(0),
    `when`(1),
    `fun`(2),
    `return`(3),
    `open`(4),
    @WireEnumConstant(declaredName = "name")
    name_(5),
    @WireEnumConstant(declaredName = "ordinal")
    ordinal_(6),
    ;

    public companion object {
      @JvmField
      public val ADAPTER: ProtoAdapter<KeywordKotlinEnum> = object : EnumAdapter<KeywordKotlinEnum>(
        KeywordKotlinEnum::class, 
        PROTO_2, 
        KeywordKotlinEnum.`object`
      ) {
        override fun fromValue(`value`: Int): KeywordKotlinEnum? = KeywordKotlinEnum.fromValue(`value`)
      }

      @JvmStatic
      public fun fromValue(`value`: Int): KeywordKotlinEnum? = when (`value`) {
        0 -> `object`
        1 -> `when`
        2 -> `fun`
        3 -> `return`
        4 -> `open`
        5 -> name_
        6 -> ordinal_
        else -> null
      }
    }
  }
}
