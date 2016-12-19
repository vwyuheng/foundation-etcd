// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

/**
 * Protobuf type {@code etcdserverpb.PutRequest}
 */
public  final class PutRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:etcdserverpb.PutRequest)
    PutRequestOrBuilder {
  // Use PutRequest.newBuilder() to construct.
  private PutRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PutRequest() {
    key_ = com.google.protobuf.ByteString.EMPTY;
    value_ = com.google.protobuf.ByteString.EMPTY;
    lease_ = 0L;
    prevKv_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private PutRequest(
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

            key_ = input.readBytes();
            break;
          }
          case 18: {

            value_ = input.readBytes();
            break;
          }
          case 24: {

            lease_ = input.readInt64();
            break;
          }
          case 32: {

            prevKv_ = input.readBool();
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
    return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.coreos.etcd3.api.PutRequest.class, com.coreos.etcd3.api.PutRequest.Builder.class);
  }

  public static final int KEY_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString key_;
  /**
   * <pre>
   * key is the key, in bytes, to put into the key-value store.
   * </pre>
   *
   * <code>optional bytes key = 1;</code>
   */
  public com.google.protobuf.ByteString getKey() {
    return key_;
  }

  public static final int VALUE_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString value_;
  /**
   * <pre>
   * value is the value, in bytes, to associate with the key in the key-value store.
   * </pre>
   *
   * <code>optional bytes value = 2;</code>
   */
  public com.google.protobuf.ByteString getValue() {
    return value_;
  }

  public static final int LEASE_FIELD_NUMBER = 3;
  private long lease_;
  /**
   * <pre>
   * lease is the lease ID to associate with the key in the key-value store. A lease
   * value of 0 indicates no lease.
   * </pre>
   *
   * <code>optional int64 lease = 3;</code>
   */
  public long getLease() {
    return lease_;
  }

  public static final int PREV_KV_FIELD_NUMBER = 4;
  private boolean prevKv_;
  /**
   * <pre>
   * If prev_kv is set, etcd gets the previous key-value pair before changing it.
   * The previous key-value pair will be returned in the put response.
   * </pre>
   *
   * <code>optional bool prev_kv = 4;</code>
   */
  public boolean getPrevKv() {
    return prevKv_;
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
    if (!key_.isEmpty()) {
      output.writeBytes(1, key_);
    }
    if (!value_.isEmpty()) {
      output.writeBytes(2, value_);
    }
    if (lease_ != 0L) {
      output.writeInt64(3, lease_);
    }
    if (prevKv_ != false) {
      output.writeBool(4, prevKv_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!key_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, key_);
    }
    if (!value_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, value_);
    }
    if (lease_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, lease_);
    }
    if (prevKv_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, prevKv_);
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
    if (!(obj instanceof com.coreos.etcd3.api.PutRequest)) {
      return super.equals(obj);
    }
    com.coreos.etcd3.api.PutRequest other = (com.coreos.etcd3.api.PutRequest) obj;

    boolean result = true;
    result = result && getKey()
        .equals(other.getKey());
    result = result && getValue()
        .equals(other.getValue());
    result = result && (getLease()
        == other.getLease());
    result = result && (getPrevKv()
        == other.getPrevKv());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + getKey().hashCode();
    hash = (37 * hash) + VALUE_FIELD_NUMBER;
    hash = (53 * hash) + getValue().hashCode();
    hash = (37 * hash) + LEASE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLease());
    hash = (37 * hash) + PREV_KV_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getPrevKv());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.coreos.etcd3.api.PutRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coreos.etcd3.api.PutRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coreos.etcd3.api.PutRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coreos.etcd3.api.PutRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coreos.etcd3.api.PutRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.PutRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coreos.etcd3.api.PutRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.PutRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coreos.etcd3.api.PutRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.PutRequest parseFrom(
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
  public static Builder newBuilder(com.coreos.etcd3.api.PutRequest prototype) {
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
   * Protobuf type {@code etcdserverpb.PutRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:etcdserverpb.PutRequest)
      com.coreos.etcd3.api.PutRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.coreos.etcd3.api.PutRequest.class, com.coreos.etcd3.api.PutRequest.Builder.class);
    }

    // Construct using com.coreos.etcd3.api.PutRequest.newBuilder()
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
      key_ = com.google.protobuf.ByteString.EMPTY;

      value_ = com.google.protobuf.ByteString.EMPTY;

      lease_ = 0L;

      prevKv_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_PutRequest_descriptor;
    }

    public com.coreos.etcd3.api.PutRequest getDefaultInstanceForType() {
      return com.coreos.etcd3.api.PutRequest.getDefaultInstance();
    }

    public com.coreos.etcd3.api.PutRequest build() {
      com.coreos.etcd3.api.PutRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.coreos.etcd3.api.PutRequest buildPartial() {
      com.coreos.etcd3.api.PutRequest result = new com.coreos.etcd3.api.PutRequest(this);
      result.key_ = key_;
      result.value_ = value_;
      result.lease_ = lease_;
      result.prevKv_ = prevKv_;
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
      if (other instanceof com.coreos.etcd3.api.PutRequest) {
        return mergeFrom((com.coreos.etcd3.api.PutRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.coreos.etcd3.api.PutRequest other) {
      if (other == com.coreos.etcd3.api.PutRequest.getDefaultInstance()) return this;
      if (other.getKey() != com.google.protobuf.ByteString.EMPTY) {
        setKey(other.getKey());
      }
      if (other.getValue() != com.google.protobuf.ByteString.EMPTY) {
        setValue(other.getValue());
      }
      if (other.getLease() != 0L) {
        setLease(other.getLease());
      }
      if (other.getPrevKv() != false) {
        setPrevKv(other.getPrevKv());
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
      com.coreos.etcd3.api.PutRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.coreos.etcd3.api.PutRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.ByteString key_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * key is the key, in bytes, to put into the key-value store.
     * </pre>
     *
     * <code>optional bytes key = 1;</code>
     */
    public com.google.protobuf.ByteString getKey() {
      return key_;
    }
    /**
     * <pre>
     * key is the key, in bytes, to put into the key-value store.
     * </pre>
     *
     * <code>optional bytes key = 1;</code>
     */
    public Builder setKey(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      key_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * key is the key, in bytes, to put into the key-value store.
     * </pre>
     *
     * <code>optional bytes key = 1;</code>
     */
    public Builder clearKey() {
      
      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString value_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * value is the value, in bytes, to associate with the key in the key-value store.
     * </pre>
     *
     * <code>optional bytes value = 2;</code>
     */
    public com.google.protobuf.ByteString getValue() {
      return value_;
    }
    /**
     * <pre>
     * value is the value, in bytes, to associate with the key in the key-value store.
     * </pre>
     *
     * <code>optional bytes value = 2;</code>
     */
    public Builder setValue(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      value_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * value is the value, in bytes, to associate with the key in the key-value store.
     * </pre>
     *
     * <code>optional bytes value = 2;</code>
     */
    public Builder clearValue() {
      
      value_ = getDefaultInstance().getValue();
      onChanged();
      return this;
    }

    private long lease_ ;
    /**
     * <pre>
     * lease is the lease ID to associate with the key in the key-value store. A lease
     * value of 0 indicates no lease.
     * </pre>
     *
     * <code>optional int64 lease = 3;</code>
     */
    public long getLease() {
      return lease_;
    }
    /**
     * <pre>
     * lease is the lease ID to associate with the key in the key-value store. A lease
     * value of 0 indicates no lease.
     * </pre>
     *
     * <code>optional int64 lease = 3;</code>
     */
    public Builder setLease(long value) {
      
      lease_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * lease is the lease ID to associate with the key in the key-value store. A lease
     * value of 0 indicates no lease.
     * </pre>
     *
     * <code>optional int64 lease = 3;</code>
     */
    public Builder clearLease() {
      
      lease_ = 0L;
      onChanged();
      return this;
    }

    private boolean prevKv_ ;
    /**
     * <pre>
     * If prev_kv is set, etcd gets the previous key-value pair before changing it.
     * The previous key-value pair will be returned in the put response.
     * </pre>
     *
     * <code>optional bool prev_kv = 4;</code>
     */
    public boolean getPrevKv() {
      return prevKv_;
    }
    /**
     * <pre>
     * If prev_kv is set, etcd gets the previous key-value pair before changing it.
     * The previous key-value pair will be returned in the put response.
     * </pre>
     *
     * <code>optional bool prev_kv = 4;</code>
     */
    public Builder setPrevKv(boolean value) {
      
      prevKv_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * If prev_kv is set, etcd gets the previous key-value pair before changing it.
     * The previous key-value pair will be returned in the put response.
     * </pre>
     *
     * <code>optional bool prev_kv = 4;</code>
     */
    public Builder clearPrevKv() {
      
      prevKv_ = false;
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


    // @@protoc_insertion_point(builder_scope:etcdserverpb.PutRequest)
  }

  // @@protoc_insertion_point(class_scope:etcdserverpb.PutRequest)
  private static final com.coreos.etcd3.api.PutRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.coreos.etcd3.api.PutRequest();
  }

  public static com.coreos.etcd3.api.PutRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PutRequest>
      PARSER = new com.google.protobuf.AbstractParser<PutRequest>() {
    public PutRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new PutRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PutRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PutRequest> getParserForType() {
    return PARSER;
  }

  public com.coreos.etcd3.api.PutRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

