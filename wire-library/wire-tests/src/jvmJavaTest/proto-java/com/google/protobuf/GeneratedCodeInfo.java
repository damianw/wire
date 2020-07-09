// Code generated by Wire protocol buffer compiler, do not edit.
// Source: google.protobuf.GeneratedCodeInfo in google/protobuf/descriptor.proto
package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

/**
 * Describes the relationship between generated code and its original source
 * file. A GeneratedCodeInfo message is associated with only one generated
 * source file, but may contain references to different source .proto files.
 */
public final class GeneratedCodeInfo extends Message<GeneratedCodeInfo, GeneratedCodeInfo.Builder> {
  public static final ProtoAdapter<GeneratedCodeInfo> ADAPTER = new ProtoAdapter_GeneratedCodeInfo();

  private static final long serialVersionUID = 0L;

  /**
   * An Annotation connects some span of text in generated code to an element
   * of its generating .proto file.
   */
  @WireField(
      tag = 1,
      adapter = "com.google.protobuf.GeneratedCodeInfo$Annotation#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<Annotation> annotation;

  public GeneratedCodeInfo(List<Annotation> annotation) {
    this(annotation, ByteString.EMPTY);
  }

  public GeneratedCodeInfo(List<Annotation> annotation, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.annotation = Internal.immutableCopyOf("annotation", annotation);
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.annotation = Internal.copyOf(annotation);
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof GeneratedCodeInfo)) return false;
    GeneratedCodeInfo o = (GeneratedCodeInfo) other;
    return unknownFields().equals(o.unknownFields())
        && annotation.equals(o.annotation);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + annotation.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (!annotation.isEmpty()) builder.append(", annotation=").append(annotation);
    return builder.replace(0, 2, "GeneratedCodeInfo{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<GeneratedCodeInfo, Builder> {
    public List<Annotation> annotation;

    public Builder() {
      annotation = Internal.newMutableList();
    }

    /**
     * An Annotation connects some span of text in generated code to an element
     * of its generating .proto file.
     */
    public Builder annotation(List<Annotation> annotation) {
      Internal.checkElementsNotNull(annotation);
      this.annotation = annotation;
      return this;
    }

    @Override
    public GeneratedCodeInfo build() {
      return new GeneratedCodeInfo(annotation, super.buildUnknownFields());
    }
  }

  public static final class Annotation extends Message<Annotation, Annotation.Builder> {
    public static final ProtoAdapter<Annotation> ADAPTER = new ProtoAdapter_Annotation();

    private static final long serialVersionUID = 0L;

    public static final String DEFAULT_SOURCE_FILE = "";

    public static final Integer DEFAULT_BEGIN = 0;

    public static final Integer DEFAULT_END = 0;

    /**
     * Identifies the element in the original source .proto file. This field
     * is formatted the same as SourceCodeInfo.Location.path.
     */
    @WireField(
        tag = 1,
        adapter = "com.squareup.wire.ProtoAdapter#INT32",
        label = WireField.Label.PACKED
    )
    public final List<Integer> path;

    /**
     * Identifies the filesystem path to the original source .proto.
     */
    @WireField(
        tag = 2,
        adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    public final String source_file;

    /**
     * Identifies the starting offset in bytes in the generated code
     * that relates to the identified object.
     */
    @WireField(
        tag = 3,
        adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    public final Integer begin;

    /**
     * Identifies the ending offset in bytes in the generated code that
     * relates to the identified offset. The end offset should be one past
     * the last relevant byte (so the length of the text = end - begin).
     */
    @WireField(
        tag = 4,
        adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    public final Integer end;

    public Annotation(List<Integer> path, String source_file, Integer begin, Integer end) {
      this(path, source_file, begin, end, ByteString.EMPTY);
    }

    public Annotation(List<Integer> path, String source_file, Integer begin, Integer end,
        ByteString unknownFields) {
      super(ADAPTER, unknownFields);
      this.path = Internal.immutableCopyOf("path", path);
      this.source_file = source_file;
      this.begin = begin;
      this.end = end;
    }

    @Override
    public Builder newBuilder() {
      Builder builder = new Builder();
      builder.path = Internal.copyOf(path);
      builder.source_file = source_file;
      builder.begin = begin;
      builder.end = end;
      builder.addUnknownFields(unknownFields());
      return builder;
    }

    @Override
    public boolean equals(Object other) {
      if (other == this) return true;
      if (!(other instanceof Annotation)) return false;
      Annotation o = (Annotation) other;
      return unknownFields().equals(o.unknownFields())
          && path.equals(o.path)
          && Internal.equals(source_file, o.source_file)
          && Internal.equals(begin, o.begin)
          && Internal.equals(end, o.end);
    }

    @Override
    public int hashCode() {
      int result = super.hashCode;
      if (result == 0) {
        result = unknownFields().hashCode();
        result = result * 37 + path.hashCode();
        result = result * 37 + (source_file != null ? source_file.hashCode() : 0);
        result = result * 37 + (begin != null ? begin.hashCode() : 0);
        result = result * 37 + (end != null ? end.hashCode() : 0);
        super.hashCode = result;
      }
      return result;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      if (!path.isEmpty()) builder.append(", path=").append(path);
      if (source_file != null) builder.append(", source_file=").append(Internal.sanitize(source_file));
      if (begin != null) builder.append(", begin=").append(begin);
      if (end != null) builder.append(", end=").append(end);
      return builder.replace(0, 2, "Annotation{").append('}').toString();
    }

    public static final class Builder extends Message.Builder<Annotation, Builder> {
      public List<Integer> path;

      public String source_file;

      public Integer begin;

      public Integer end;

      public Builder() {
        path = Internal.newMutableList();
      }

      /**
       * Identifies the element in the original source .proto file. This field
       * is formatted the same as SourceCodeInfo.Location.path.
       */
      public Builder path(List<Integer> path) {
        Internal.checkElementsNotNull(path);
        this.path = path;
        return this;
      }

      /**
       * Identifies the filesystem path to the original source .proto.
       */
      public Builder source_file(String source_file) {
        this.source_file = source_file;
        return this;
      }

      /**
       * Identifies the starting offset in bytes in the generated code
       * that relates to the identified object.
       */
      public Builder begin(Integer begin) {
        this.begin = begin;
        return this;
      }

      /**
       * Identifies the ending offset in bytes in the generated code that
       * relates to the identified offset. The end offset should be one past
       * the last relevant byte (so the length of the text = end - begin).
       */
      public Builder end(Integer end) {
        this.end = end;
        return this;
      }

      @Override
      public Annotation build() {
        return new Annotation(path, source_file, begin, end, super.buildUnknownFields());
      }
    }

    private static final class ProtoAdapter_Annotation extends ProtoAdapter<Annotation> {
      public ProtoAdapter_Annotation() {
        super(FieldEncoding.LENGTH_DELIMITED, Annotation.class, "type.googleapis.com/google.protobuf.GeneratedCodeInfo.Annotation", Syntax.PROTO_2);
      }

      @Override
      public int encodedSize(Annotation value) {
        return ProtoAdapter.INT32.asPacked().encodedSizeWithTag(1, value.path)
            + ProtoAdapter.STRING.encodedSizeWithTag(2, value.source_file)
            + ProtoAdapter.INT32.encodedSizeWithTag(3, value.begin)
            + ProtoAdapter.INT32.encodedSizeWithTag(4, value.end)
            + value.unknownFields().size();
      }

      @Override
      public void encode(ProtoWriter writer, Annotation value) throws IOException {
        ProtoAdapter.INT32.asPacked().encodeWithTag(writer, 1, value.path);
        ProtoAdapter.STRING.encodeWithTag(writer, 2, value.source_file);
        ProtoAdapter.INT32.encodeWithTag(writer, 3, value.begin);
        ProtoAdapter.INT32.encodeWithTag(writer, 4, value.end);
        writer.writeBytes(value.unknownFields());
      }

      @Override
      public Annotation decode(ProtoReader reader) throws IOException {
        Builder builder = new Builder();
        long token = reader.beginMessage();
        for (int tag; (tag = reader.nextTag()) != -1;) {
          switch (tag) {
            case 1: builder.path.add(ProtoAdapter.INT32.decode(reader)); break;
            case 2: builder.source_file(ProtoAdapter.STRING.decode(reader)); break;
            case 3: builder.begin(ProtoAdapter.INT32.decode(reader)); break;
            case 4: builder.end(ProtoAdapter.INT32.decode(reader)); break;
            default: {
              reader.readUnknownField(tag);
            }
          }
        }
        builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
        return builder.build();
      }

      @Override
      public Annotation redact(Annotation value) {
        Builder builder = value.newBuilder();
        builder.clearUnknownFields();
        return builder.build();
      }
    }
  }

  private static final class ProtoAdapter_GeneratedCodeInfo extends ProtoAdapter<GeneratedCodeInfo> {
    public ProtoAdapter_GeneratedCodeInfo() {
      super(FieldEncoding.LENGTH_DELIMITED, GeneratedCodeInfo.class, "type.googleapis.com/google.protobuf.GeneratedCodeInfo", Syntax.PROTO_2);
    }

    @Override
    public int encodedSize(GeneratedCodeInfo value) {
      return Annotation.ADAPTER.asRepeated().encodedSizeWithTag(1, value.annotation)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, GeneratedCodeInfo value) throws IOException {
      Annotation.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.annotation);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public GeneratedCodeInfo decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.annotation.add(Annotation.ADAPTER.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public GeneratedCodeInfo redact(GeneratedCodeInfo value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.annotation, Annotation.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
