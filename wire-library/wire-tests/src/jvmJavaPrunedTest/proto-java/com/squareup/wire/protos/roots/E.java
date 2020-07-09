// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.roots.E in roots.proto
package com.squareup.wire.protos.roots;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.AssertionError;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

/**
 * <b>NOTE:</b> This type only exists to maintain class structure for its nested types and is not an actual message.
 */
public final class E {
  private E() {
    throw new AssertionError();
  }

  public static final class F extends Message<F, F.Builder> {
    public static final ProtoAdapter<F> ADAPTER = new ProtoAdapter_F();

    private static final long serialVersionUID = 0L;

    public static final Integer DEFAULT_I = 0;

    @WireField(
        tag = 1,
        adapter = "com.squareup.wire.ProtoAdapter#INT32"
    )
    public final Integer i;

    public F(Integer i) {
      this(i, ByteString.EMPTY);
    }

    public F(Integer i, ByteString unknownFields) {
      super(ADAPTER, unknownFields);
      this.i = i;
    }

    @Override
    public Builder newBuilder() {
      Builder builder = new Builder();
      builder.i = i;
      builder.addUnknownFields(unknownFields());
      return builder;
    }

    @Override
    public boolean equals(Object other) {
      if (other == this) return true;
      if (!(other instanceof F)) return false;
      F o = (F) other;
      return unknownFields().equals(o.unknownFields())
          && Internal.equals(i, o.i);
    }

    @Override
    public int hashCode() {
      int result = super.hashCode;
      if (result == 0) {
        result = unknownFields().hashCode();
        result = result * 37 + (i != null ? i.hashCode() : 0);
        super.hashCode = result;
      }
      return result;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      if (i != null) builder.append(", i=").append(i);
      return builder.replace(0, 2, "F{").append('}').toString();
    }

    public static final class Builder extends Message.Builder<F, Builder> {
      public Integer i;

      public Builder() {
      }

      public Builder i(Integer i) {
        this.i = i;
        return this;
      }

      @Override
      public F build() {
        return new F(i, super.buildUnknownFields());
      }
    }

    private static final class ProtoAdapter_F extends ProtoAdapter<F> {
      public ProtoAdapter_F() {
        super(FieldEncoding.LENGTH_DELIMITED, F.class, "type.googleapis.com/squareup.protos.roots.E.F", Syntax.PROTO_2);
      }

      @Override
      public int encodedSize(F value) {
        return ProtoAdapter.INT32.encodedSizeWithTag(1, value.i)
            + value.unknownFields().size();
      }

      @Override
      public void encode(ProtoWriter writer, F value) throws IOException {
        ProtoAdapter.INT32.encodeWithTag(writer, 1, value.i);
        writer.writeBytes(value.unknownFields());
      }

      @Override
      public F decode(ProtoReader reader) throws IOException {
        Builder builder = new Builder();
        long token = reader.beginMessage();
        for (int tag; (tag = reader.nextTag()) != -1;) {
          switch (tag) {
            case 1: builder.i(ProtoAdapter.INT32.decode(reader)); break;
            default: {
              reader.readUnknownField(tag);
            }
          }
        }
        builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
        return builder.build();
      }

      @Override
      public F redact(F value) {
        Builder builder = value.newBuilder();
        builder.clearUnknownFields();
        return builder.build();
      }
    }
  }
}
