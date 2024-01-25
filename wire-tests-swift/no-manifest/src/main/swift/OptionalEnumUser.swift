// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.OptionalEnumUser in optional_enum.proto
import Wire

public struct OptionalEnumUser {

    public var optional_enum: OptionalEnumUser.OptionalEnum?
    public var unknownFields: UnknownFields = .init()

    public init(configure: (inout Self) -> Swift.Void = { _ in }) {
        configure(&self)
    }

}

#if !WIRE_REMOVE_EQUATABLE
extension OptionalEnumUser : Equatable {
}
#endif

#if !WIRE_REMOVE_HASHABLE
extension OptionalEnumUser : Hashable {
}
#endif

extension OptionalEnumUser : Sendable {
}

extension OptionalEnumUser : ProtoDefaultedValue {

    public static var defaultedValue: OptionalEnumUser {
        OptionalEnumUser()
    }
}

extension OptionalEnumUser : ProtoMessage {

    public static func protoMessageTypeURL() -> String {
        return "type.googleapis.com/squareup.protos.kotlin.OptionalEnumUser"
    }

}

extension OptionalEnumUser : Proto2Codable {

    public init(from protoReader: ProtoReader) throws {
        var optional_enum: OptionalEnumUser.OptionalEnum? = nil

        let token = try protoReader.beginMessage()
        while let tag = try protoReader.nextTag(token: token) {
            switch tag {
            case 1: optional_enum = try protoReader.decode(OptionalEnumUser.OptionalEnum.self)
            default: try protoReader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try protoReader.endMessage(token: token)

        self.optional_enum = optional_enum
    }

    public func encode(to protoWriter: ProtoWriter) throws {
        try protoWriter.encode(tag: 1, value: self.optional_enum)
        try protoWriter.writeUnknownFields(unknownFields)
    }

}

#if !WIRE_REMOVE_CODABLE
extension OptionalEnumUser : Codable {

    public init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: StringLiteralCodingKeys.self)
        self.optional_enum = try container.decodeIfPresent(OptionalEnumUser.OptionalEnum.self, firstOfKeys: "optionalEnum", "optional_enum")
    }

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: StringLiteralCodingKeys.self)
        let preferCamelCase = encoder.protoKeyNameEncodingStrategy == .camelCase

        try container.encodeIfPresent(self.optional_enum, forKey: preferCamelCase ? "optionalEnum" : "optional_enum")
    }

}
#endif

/**
 * Subtypes within OptionalEnumUser
 */
extension OptionalEnumUser {

    public enum OptionalEnum : Int32, CaseIterable, Proto2Enum {

        case FOO = 1
        case BAR = 2

        public var description: String {
            switch self {
            case .FOO: return "FOO"
            case .BAR: return "BAR"
            }
        }

    }

}

extension OptionalEnumUser.OptionalEnum : Sendable {
}
