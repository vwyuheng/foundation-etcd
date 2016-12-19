// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

/**
 * Protobuf type {@code etcdserverpb.AuthRoleGetResponse}
 */
public  final class AuthRoleGetResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:etcdserverpb.AuthRoleGetResponse)
    AuthRoleGetResponseOrBuilder {
  // Use AuthRoleGetResponse.newBuilder() to construct.
  private AuthRoleGetResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AuthRoleGetResponse() {
    perm_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private AuthRoleGetResponse(
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
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              perm_ = new java.util.ArrayList<authpb.Auth.Permission>();
              mutable_bitField0_ |= 0x00000002;
            }
            perm_.add(
                input.readMessage(authpb.Auth.Permission.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        perm_ = java.util.Collections.unmodifiableList(perm_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_AuthRoleGetResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_AuthRoleGetResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.coreos.etcd3.api.AuthRoleGetResponse.class, com.coreos.etcd3.api.AuthRoleGetResponse.Builder.class);
  }

  private int bitField0_;
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

  public static final int PERM_FIELD_NUMBER = 2;
  private java.util.List<authpb.Auth.Permission> perm_;
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  public java.util.List<authpb.Auth.Permission> getPermList() {
    return perm_;
  }
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  public java.util.List<? extends authpb.Auth.PermissionOrBuilder> 
      getPermOrBuilderList() {
    return perm_;
  }
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  public int getPermCount() {
    return perm_.size();
  }
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  public authpb.Auth.Permission getPerm(int index) {
    return perm_.get(index);
  }
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  public authpb.Auth.PermissionOrBuilder getPermOrBuilder(
      int index) {
    return perm_.get(index);
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
    for (int i = 0; i < perm_.size(); i++) {
      output.writeMessage(2, perm_.get(i));
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
    for (int i = 0; i < perm_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, perm_.get(i));
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
    if (!(obj instanceof com.coreos.etcd3.api.AuthRoleGetResponse)) {
      return super.equals(obj);
    }
    com.coreos.etcd3.api.AuthRoleGetResponse other = (com.coreos.etcd3.api.AuthRoleGetResponse) obj;

    boolean result = true;
    result = result && (hasHeader() == other.hasHeader());
    if (hasHeader()) {
      result = result && getHeader()
          .equals(other.getHeader());
    }
    result = result && getPermList()
        .equals(other.getPermList());
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
    if (getPermCount() > 0) {
      hash = (37 * hash) + PERM_FIELD_NUMBER;
      hash = (53 * hash) + getPermList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.coreos.etcd3.api.AuthRoleGetResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.coreos.etcd3.api.AuthRoleGetResponse parseFrom(
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
  public static Builder newBuilder(com.coreos.etcd3.api.AuthRoleGetResponse prototype) {
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
   * Protobuf type {@code etcdserverpb.AuthRoleGetResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:etcdserverpb.AuthRoleGetResponse)
      com.coreos.etcd3.api.AuthRoleGetResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_AuthRoleGetResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_AuthRoleGetResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.coreos.etcd3.api.AuthRoleGetResponse.class, com.coreos.etcd3.api.AuthRoleGetResponse.Builder.class);
    }

    // Construct using com.coreos.etcd3.api.AuthRoleGetResponse.newBuilder()
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
        getPermFieldBuilder();
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
      if (permBuilder_ == null) {
        perm_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        permBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.coreos.etcd3.api.Rpc.internal_static_etcdserverpb_AuthRoleGetResponse_descriptor;
    }

    public com.coreos.etcd3.api.AuthRoleGetResponse getDefaultInstanceForType() {
      return com.coreos.etcd3.api.AuthRoleGetResponse.getDefaultInstance();
    }

    public com.coreos.etcd3.api.AuthRoleGetResponse build() {
      com.coreos.etcd3.api.AuthRoleGetResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.coreos.etcd3.api.AuthRoleGetResponse buildPartial() {
      com.coreos.etcd3.api.AuthRoleGetResponse result = new com.coreos.etcd3.api.AuthRoleGetResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (headerBuilder_ == null) {
        result.header_ = header_;
      } else {
        result.header_ = headerBuilder_.build();
      }
      if (permBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          perm_ = java.util.Collections.unmodifiableList(perm_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.perm_ = perm_;
      } else {
        result.perm_ = permBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof com.coreos.etcd3.api.AuthRoleGetResponse) {
        return mergeFrom((com.coreos.etcd3.api.AuthRoleGetResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.coreos.etcd3.api.AuthRoleGetResponse other) {
      if (other == com.coreos.etcd3.api.AuthRoleGetResponse.getDefaultInstance()) return this;
      if (other.hasHeader()) {
        mergeHeader(other.getHeader());
      }
      if (permBuilder_ == null) {
        if (!other.perm_.isEmpty()) {
          if (perm_.isEmpty()) {
            perm_ = other.perm_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensurePermIsMutable();
            perm_.addAll(other.perm_);
          }
          onChanged();
        }
      } else {
        if (!other.perm_.isEmpty()) {
          if (permBuilder_.isEmpty()) {
            permBuilder_.dispose();
            permBuilder_ = null;
            perm_ = other.perm_;
            bitField0_ = (bitField0_ & ~0x00000002);
            permBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPermFieldBuilder() : null;
          } else {
            permBuilder_.addAllMessages(other.perm_);
          }
        }
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
      com.coreos.etcd3.api.AuthRoleGetResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.coreos.etcd3.api.AuthRoleGetResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

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

    private java.util.List<authpb.Auth.Permission> perm_ =
      java.util.Collections.emptyList();
    private void ensurePermIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        perm_ = new java.util.ArrayList<authpb.Auth.Permission>(perm_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        authpb.Auth.Permission, authpb.Auth.Permission.Builder, authpb.Auth.PermissionOrBuilder> permBuilder_;

    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public java.util.List<authpb.Auth.Permission> getPermList() {
      if (permBuilder_ == null) {
        return java.util.Collections.unmodifiableList(perm_);
      } else {
        return permBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public int getPermCount() {
      if (permBuilder_ == null) {
        return perm_.size();
      } else {
        return permBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public authpb.Auth.Permission getPerm(int index) {
      if (permBuilder_ == null) {
        return perm_.get(index);
      } else {
        return permBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder setPerm(
        int index, authpb.Auth.Permission value) {
      if (permBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePermIsMutable();
        perm_.set(index, value);
        onChanged();
      } else {
        permBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder setPerm(
        int index, authpb.Auth.Permission.Builder builderForValue) {
      if (permBuilder_ == null) {
        ensurePermIsMutable();
        perm_.set(index, builderForValue.build());
        onChanged();
      } else {
        permBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder addPerm(authpb.Auth.Permission value) {
      if (permBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePermIsMutable();
        perm_.add(value);
        onChanged();
      } else {
        permBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder addPerm(
        int index, authpb.Auth.Permission value) {
      if (permBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePermIsMutable();
        perm_.add(index, value);
        onChanged();
      } else {
        permBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder addPerm(
        authpb.Auth.Permission.Builder builderForValue) {
      if (permBuilder_ == null) {
        ensurePermIsMutable();
        perm_.add(builderForValue.build());
        onChanged();
      } else {
        permBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder addPerm(
        int index, authpb.Auth.Permission.Builder builderForValue) {
      if (permBuilder_ == null) {
        ensurePermIsMutable();
        perm_.add(index, builderForValue.build());
        onChanged();
      } else {
        permBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder addAllPerm(
        java.lang.Iterable<? extends authpb.Auth.Permission> values) {
      if (permBuilder_ == null) {
        ensurePermIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, perm_);
        onChanged();
      } else {
        permBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder clearPerm() {
      if (permBuilder_ == null) {
        perm_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        permBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public Builder removePerm(int index) {
      if (permBuilder_ == null) {
        ensurePermIsMutable();
        perm_.remove(index);
        onChanged();
      } else {
        permBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public authpb.Auth.Permission.Builder getPermBuilder(
        int index) {
      return getPermFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public authpb.Auth.PermissionOrBuilder getPermOrBuilder(
        int index) {
      if (permBuilder_ == null) {
        return perm_.get(index);  } else {
        return permBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public java.util.List<? extends authpb.Auth.PermissionOrBuilder> 
         getPermOrBuilderList() {
      if (permBuilder_ != null) {
        return permBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(perm_);
      }
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public authpb.Auth.Permission.Builder addPermBuilder() {
      return getPermFieldBuilder().addBuilder(
          authpb.Auth.Permission.getDefaultInstance());
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public authpb.Auth.Permission.Builder addPermBuilder(
        int index) {
      return getPermFieldBuilder().addBuilder(
          index, authpb.Auth.Permission.getDefaultInstance());
    }
    /**
     * <code>repeated .authpb.Permission perm = 2;</code>
     */
    public java.util.List<authpb.Auth.Permission.Builder> 
         getPermBuilderList() {
      return getPermFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        authpb.Auth.Permission, authpb.Auth.Permission.Builder, authpb.Auth.PermissionOrBuilder> 
        getPermFieldBuilder() {
      if (permBuilder_ == null) {
        permBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            authpb.Auth.Permission, authpb.Auth.Permission.Builder, authpb.Auth.PermissionOrBuilder>(
                perm_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        perm_ = null;
      }
      return permBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:etcdserverpb.AuthRoleGetResponse)
  }

  // @@protoc_insertion_point(class_scope:etcdserverpb.AuthRoleGetResponse)
  private static final com.coreos.etcd3.api.AuthRoleGetResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.coreos.etcd3.api.AuthRoleGetResponse();
  }

  public static com.coreos.etcd3.api.AuthRoleGetResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AuthRoleGetResponse>
      PARSER = new com.google.protobuf.AbstractParser<AuthRoleGetResponse>() {
    public AuthRoleGetResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new AuthRoleGetResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AuthRoleGetResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AuthRoleGetResponse> getParserForType() {
    return PARSER;
  }

  public com.coreos.etcd3.api.AuthRoleGetResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

