// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

/**
 * Protobuf type {@code etcdserverpb.PutResponse}
 */
public  final class PutResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:etcdserverpb.PutResponse)
    PutResponseOrBuilder {
  // Use PutResponse.newBuilder() to construct.
  private PutResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PutResponse() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private PutResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            com.coreos.etcd3.api.ResponseHeader.Builder subBuilder = null;
            if (header_ != null) {
              subBuilder = header_.toBuilder();
            }
            header_ = input.readMessage(com.coreos.etcd3.api.ResponseHeader.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(header_);
              header_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            mvccpb.Kv.KeyValue.Builder subBuilder = null;
            if (prevKv_ != null) {
              subBuilder = prevKv_.toBuilder();
            }
            prevKv_ = input.readMessage(mvccpb.Kv.KeyValue.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(prevKv_);
              prevKv_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.coreos.etcd3.api.PutResponse.class, com.coreos.etcd3.api.PutResponse.Builder.class);
  }

  public static final int HEADER_FIELD_NUMBER = 1;
  private com.coreos.etcd3.api.ResponseHeader header_;
  /**
   * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
   */
  public boolean hasHeader() {
    return header_ != null;
  }
  /**
   * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
   */
  public com.coreos.etcd3.api.ResponseHeader getHeader() {
    return header_ == null ? com.coreos.etcd3.api.ResponseHeader.getDefaultInstance() : header_;
  }
  /**
   * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
   */
  public com.coreos.etcd3.api.ResponseHeaderOrBuilder getHeaderOrBuilder() {
    return getHeader();
  }

  public static final int PREV_KV_FIELD_NUMBER = 2;
  private mvccpb.Kv.KeyValue prevKv_;
  /**
   * <pre>
   * if prev_kv is set in the request, the previous key-value pair will be returned.
   * </pre>
   *
   * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
   */
  public boolean hasPrevKv() {
    return prevKv_ != null;
  }
  /**
   * <pre>
   * if prev_kv is set in the request, the previous key-value pair will be returned.
   * </pre>
   *
   * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
   */
  public mvccpb.Kv.KeyValue getPrevKv() {
    return prevKv_ == null ? mvccpb.Kv.KeyValue.getDefaultInstance() : prevKv_;
  }
  /**
   * <pre>
   * if prev_kv is set in the request, the previous key-value pair will be returned.
   * </pre>
   *
   * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
   */
  public mvccpb.Kv.KeyValueOrBuilder getPrevKvOrBuilder() {
    return getPrevKv();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (header_ != null) {
      output.writeMessage(1, getHeader());
    }
    if (prevKv_ != null) {
      output.writeMessage(2, getPrevKv());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (header_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getHeader());
    }
    if (prevKv_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getPrevKv());
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.coreos.etcd3.api.PutResponse)) {
      return super.equals(obj);
    }
    com.coreos.etcd3.api.PutResponse other = (com.coreos.etcd3.api.PutResponse) obj;

    boolean result = true;
    result = result && (hasHeader() == other.hasHeader());
    if (hasHeader()) {
      result = result && getHeader()
          .equals(other.getHeader());
    }
    result = result && (hasPrevKv() == other.hasPrevKv());
    if (hasPrevKv()) {
      result = result && getPrevKv()
          .equals(other.getPrevKv());
    }
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (hasHeader()) {
      hash = (37 * hash) + HEADER_FIELD_NUMBER;
      hash = (53 * hash) + getHeader().hashCode();
    }
    if (hasPrevKv()) {
      hash = (37 * hash) + PREV_KV_FIELD_NUMBER;
      hash = (53 * hash) + getPrevKv().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.coreos.etcd3.api.PutResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coreos.etcd3.api.PutResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coreos.etcd3.api.PutResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coreos.etcd3.api.PutResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coreos.etcd3.api.PutResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.PutResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coreos.etcd3.api.PutResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.PutResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coreos.etcd3.api.PutResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.PutResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.coreos.etcd3.api.PutResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code etcdserverpb.PutResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:etcdserverpb.PutResponse)
      com.coreos.etcd3.api.PutResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.coreos.etcd3.api.PutResponse.class, com.coreos.etcd3.api.PutResponse.Builder.class);
    }

    // Construct using com.coreos.etcd3.api.PutResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (headerBuilder_ == null) {
        header_ = null;
      } else {
        header_ = null;
        headerBuilder_ = null;
      }
      if (prevKvBuilder_ == null) {
        prevKv_ = null;
      } else {
        prevKv_ = null;
        prevKvBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutResponse_descriptor;
    }

    public com.coreos.etcd3.api.PutResponse getDefaultInstanceForType() {
      return com.coreos.etcd3.api.PutResponse.getDefaultInstance();
    }

    public com.coreos.etcd3.api.PutResponse build() {
      com.coreos.etcd3.api.PutResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.coreos.etcd3.api.PutResponse buildPartial() {
      com.coreos.etcd3.api.PutResponse result = new com.coreos.etcd3.api.PutResponse(this);
      if (headerBuilder_ == null) {
        result.header_ = header_;
      } else {
        result.header_ = headerBuilder_.build();
      }
      if (prevKvBuilder_ == null) {
        result.prevKv_ = prevKv_;
      } else {
        result.prevKv_ = prevKvBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.coreos.etcd3.api.PutResponse) {
        return mergeFrom((com.coreos.etcd3.api.PutResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.coreos.etcd3.api.PutResponse other) {
      if (other == com.coreos.etcd3.api.PutResponse.getDefaultInstance()) return this;
      if (other.hasHeader()) {
        mergeHeader(other.getHeader());
      }
      if (other.hasPrevKv()) {
        mergePrevKv(other.getPrevKv());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.coreos.etcd3.api.PutResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.coreos.etcd3.api.PutResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.coreos.etcd3.api.ResponseHeader header_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.coreos.etcd3.api.ResponseHeader, com.coreos.etcd3.api.ResponseHeader.Builder, com.coreos.etcd3.api.ResponseHeaderOrBuilder> headerBuilder_;
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    public boolean hasHeader() {
      return headerBuilder_ != null || header_ != null;
    }
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    public com.coreos.etcd3.api.ResponseHeader getHeader() {
      if (headerBuilder_ == null) {
        return header_ == null ? com.coreos.etcd3.api.ResponseHeader.getDefaultInstance() : header_;
      } else {
        return headerBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    public Builder setHeader(com.coreos.etcd3.api.ResponseHeader value) {
      if (headerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        header_ = value;
        onChanged();
      } else {
        headerBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    public Builder setHeader(
        com.coreos.etcd3.api.ResponseHeader.Builder builderForValue) {
      if (headerBuilder_ == null) {
        header_ = builderForValue.build();
        onChanged();
      } else {
        headerBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    public Builder mergeHeader(com.coreos.etcd3.api.ResponseHeader value) {
      if (headerBuilder_ == null) {
        if (header_ != null) {
          header_ =
            com.coreos.etcd3.api.ResponseHeader.newBuilder(header_).mergeFrom(value).buildPartial();
        } else {
          header_ = value;
        }
        onChanged();
      } else {
        headerBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    public Builder clearHeader() {
      if (headerBuilder_ == null) {
        header_ = null;
        onChanged();
      } else {
        header_ = null;
        headerBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    public com.coreos.etcd3.api.ResponseHeader.Builder getHeaderBuilder() {
      
      onChanged();
      return getHeaderFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    public com.coreos.etcd3.api.ResponseHeaderOrBuilder getHeaderOrBuilder() {
      if (headerBuilder_ != null) {
        return headerBuilder_.getMessageOrBuilder();
      } else {
        return header_ == null ?
            com.coreos.etcd3.api.ResponseHeader.getDefaultInstance() : header_;
      }
    }
    /**
     * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.coreos.etcd3.api.ResponseHeader, com.coreos.etcd3.api.ResponseHeader.Builder, com.coreos.etcd3.api.ResponseHeaderOrBuilder> 
        getHeaderFieldBuilder() {
      if (headerBuilder_ == null) {
        headerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.coreos.etcd3.api.ResponseHeader, com.coreos.etcd3.api.ResponseHeader.Builder, com.coreos.etcd3.api.ResponseHeaderOrBuilder>(
                getHeader(),
                getParentForChildren(),
                isClean());
        header_ = null;
      }
      return headerBuilder_;
    }

    private mvccpb.Kv.KeyValue prevKv_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        mvccpb.Kv.KeyValue, mvccpb.Kv.KeyValue.Builder, mvccpb.Kv.KeyValueOrBuilder> prevKvBuilder_;
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    public boolean hasPrevKv() {
      return prevKvBuilder_ != null || prevKv_ != null;
    }
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    public mvccpb.Kv.KeyValue getPrevKv() {
      if (prevKvBuilder_ == null) {
        return prevKv_ == null ? mvccpb.Kv.KeyValue.getDefaultInstance() : prevKv_;
      } else {
        return prevKvBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    public Builder setPrevKv(mvccpb.Kv.KeyValue value) {
      if (prevKvBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        prevKv_ = value;
        onChanged();
      } else {
        prevKvBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    public Builder setPrevKv(
        mvccpb.Kv.KeyValue.Builder builderForValue) {
      if (prevKvBuilder_ == null) {
        prevKv_ = builderForValue.build();
        onChanged();
      } else {
        prevKvBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    public Builder mergePrevKv(mvccpb.Kv.KeyValue value) {
      if (prevKvBuilder_ == null) {
        if (prevKv_ != null) {
          prevKv_ =
            mvccpb.Kv.KeyValue.newBuilder(prevKv_).mergeFrom(value).buildPartial();
        } else {
          prevKv_ = value;
        }
        onChanged();
      } else {
        prevKvBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    public Builder clearPrevKv() {
      if (prevKvBuilder_ == null) {
        prevKv_ = null;
        onChanged();
      } else {
        prevKv_ = null;
        prevKvBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    public mvccpb.Kv.KeyValue.Builder getPrevKvBuilder() {
      
      onChanged();
      return getPrevKvFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    public mvccpb.Kv.KeyValueOrBuilder getPrevKvOrBuilder() {
      if (prevKvBuilder_ != null) {
        return prevKvBuilder_.getMessageOrBuilder();
      } else {
        return prevKv_ == null ?
            mvccpb.Kv.KeyValue.getDefaultInstance() : prevKv_;
      }
    }
    /**
     * <pre>
     * if prev_kv is set in the request, the previous key-value pair will be returned.
     * </pre>
     *
     * <code>optional .mvccpb.KeyValue prev_kv = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        mvccpb.Kv.KeyValue, mvccpb.Kv.KeyValue.Builder, mvccpb.Kv.KeyValueOrBuilder> 
        getPrevKvFieldBuilder() {
      if (prevKvBuilder_ == null) {
        prevKvBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            mvccpb.Kv.KeyValue, mvccpb.Kv.KeyValue.Builder, mvccpb.Kv.KeyValueOrBuilder>(
                getPrevKv(),
                getParentForChildren(),
                isClean());
        prevKv_ = null;
      }
      return prevKvBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:etcdserverpb.PutResponse)
  }

  // @@protoc_insertion_point(class_scope:etcdserverpb.PutResponse)
  private static final com.coreos.etcd3.api.PutResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.coreos.etcd3.api.PutResponse();
  }

  public static com.coreos.etcd3.api.PutResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PutResponse>
      PARSER = new com.google.protobuf.AbstractParser<PutResponse>() {
    public PutResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new PutResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PutResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PutResponse> getParserForType() {
    return PARSER;
  }

  public com.coreos.etcd3.api.PutResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

