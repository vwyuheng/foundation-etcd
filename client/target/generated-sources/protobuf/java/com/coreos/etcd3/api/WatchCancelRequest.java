// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

/**
 * Protobuf type {@code etcdserverpb.WatchCancelRequest}
 */
public  final class WatchCancelRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:etcdserverpb.WatchCancelRequest)
    WatchCancelRequestOrBuilder {
  // Use WatchCancelRequest.newBuilder() to construct.
  private WatchCancelRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WatchCancelRequest() {
    watchId_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private WatchCancelRequest(
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
          case 8: {

            watchId_ = input.readInt64();
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
    return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_WatchCancelRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_WatchCancelRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.coreos.etcd3.api.WatchCancelRequest.class, com.coreos.etcd3.api.WatchCancelRequest.Builder.class);
  }

  public static final int WATCH_ID_FIELD_NUMBER = 1;
  private long watchId_;
  /**
   * <pre>
   * watch_id is the watcher id to cancel so that no more events are transmitted.
   * </pre>
   *
   * <code>optional int64 watch_id = 1;</code>
   */
  public long getWatchId() {
    return watchId_;
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
    if (watchId_ != 0L) {
      output.writeInt64(1, watchId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (watchId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, watchId_);
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
    if (!(obj instanceof com.coreos.etcd3.api.WatchCancelRequest)) {
      return super.equals(obj);
    }
    com.coreos.etcd3.api.WatchCancelRequest other = (com.coreos.etcd3.api.WatchCancelRequest) obj;

    boolean result = true;
    result = result && (getWatchId()
        == other.getWatchId());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + WATCH_ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getWatchId());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.coreos.etcd3.api.WatchCancelRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.WatchCancelRequest parseFrom(
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
  public static Builder newBuilder(com.coreos.etcd3.api.WatchCancelRequest prototype) {
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
   * Protobuf type {@code etcdserverpb.WatchCancelRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:etcdserverpb.WatchCancelRequest)
      com.coreos.etcd3.api.WatchCancelRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_WatchCancelRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_WatchCancelRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.coreos.etcd3.api.WatchCancelRequest.class, com.coreos.etcd3.api.WatchCancelRequest.Builder.class);
    }

    // Construct using com.coreos.etcd3.api.WatchCancelRequest.newBuilder()
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
      watchId_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_WatchCancelRequest_descriptor;
    }

    public com.coreos.etcd3.api.WatchCancelRequest getDefaultInstanceForType() {
      return com.coreos.etcd3.api.WatchCancelRequest.getDefaultInstance();
    }

    public com.coreos.etcd3.api.WatchCancelRequest build() {
      com.coreos.etcd3.api.WatchCancelRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.coreos.etcd3.api.WatchCancelRequest buildPartial() {
      com.coreos.etcd3.api.WatchCancelRequest result = new com.coreos.etcd3.api.WatchCancelRequest(this);
      result.watchId_ = watchId_;
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
      if (other instanceof com.coreos.etcd3.api.WatchCancelRequest) {
        return mergeFrom((com.coreos.etcd3.api.WatchCancelRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.coreos.etcd3.api.WatchCancelRequest other) {
      if (other == com.coreos.etcd3.api.WatchCancelRequest.getDefaultInstance()) return this;
      if (other.getWatchId() != 0L) {
        setWatchId(other.getWatchId());
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
      com.coreos.etcd3.api.WatchCancelRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.coreos.etcd3.api.WatchCancelRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long watchId_ ;
    /**
     * <pre>
     * watch_id is the watcher id to cancel so that no more events are transmitted.
     * </pre>
     *
     * <code>optional int64 watch_id = 1;</code>
     */
    public long getWatchId() {
      return watchId_;
    }
    /**
     * <pre>
     * watch_id is the watcher id to cancel so that no more events are transmitted.
     * </pre>
     *
     * <code>optional int64 watch_id = 1;</code>
     */
    public Builder setWatchId(long value) {
      
      watchId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * watch_id is the watcher id to cancel so that no more events are transmitted.
     * </pre>
     *
     * <code>optional int64 watch_id = 1;</code>
     */
    public Builder clearWatchId() {
      
      watchId_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:etcdserverpb.WatchCancelRequest)
  }

  // @@protoc_insertion_point(class_scope:etcdserverpb.WatchCancelRequest)
  private static final com.coreos.etcd3.api.WatchCancelRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.coreos.etcd3.api.WatchCancelRequest();
  }

  public static com.coreos.etcd3.api.WatchCancelRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WatchCancelRequest>
      PARSER = new com.google.protobuf.AbstractParser<WatchCancelRequest>() {
    public WatchCancelRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new WatchCancelRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<WatchCancelRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WatchCancelRequest> getParserForType() {
    return PARSER;
  }

  public com.coreos.etcd3.api.WatchCancelRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

