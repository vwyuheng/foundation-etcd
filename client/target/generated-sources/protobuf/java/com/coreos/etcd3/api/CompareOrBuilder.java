// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface CompareOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.Compare)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * result is logical comparison operation for this comparison.
   * </pre>
   *
   * <code>optional .etcdserverpb.Compare.CompareResult result = 1;</code>
   */
  int getResultValue();
  /**
   * <pre>
   * result is logical comparison operation for this comparison.
   * </pre>
   *
   * <code>optional .etcdserverpb.Compare.CompareResult result = 1;</code>
   */
  com.coreos.etcd3.api.Compare.CompareResult getResult();

  /**
   * <pre>
   * target is the key-value field to inspect for the comparison.
   * </pre>
   *
   * <code>optional .etcdserverpb.Compare.CompareTarget target = 2;</code>
   */
  int getTargetValue();
  /**
   * <pre>
   * target is the key-value field to inspect for the comparison.
   * </pre>
   *
   * <code>optional .etcdserverpb.Compare.CompareTarget target = 2;</code>
   */
  com.coreos.etcd3.api.Compare.CompareTarget getTarget();

  /**
   * <pre>
   * key is the subject key for the comparison operation.
   * </pre>
   *
   * <code>optional bytes key = 3;</code>
   */
  com.google.protobuf.ByteString getKey();

  /**
   * <pre>
   * version is the version of the given key
   * </pre>
   *
   * <code>optional int64 version = 4;</code>
   */
  long getVersion();

  /**
   * <pre>
   * create_revision is the creation revision of the given key
   * </pre>
   *
   * <code>optional int64 create_revision = 5;</code>
   */
  long getCreateRevision();

  /**
   * <pre>
   * mod_revision is the last modified revision of the given key.
   * </pre>
   *
   * <code>optional int64 mod_revision = 6;</code>
   */
  long getModRevision();

  /**
   * <pre>
   * value is the value of the given key, in bytes.
   * </pre>
   *
   * <code>optional bytes value = 7;</code>
   */
  com.google.protobuf.ByteString getValue();

  public com.coreos.etcd3.api.Compare.TargetUnionCase getTargetUnionCase();
}