// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface PutRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.PutRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * key is the key, in bytes, to put into the key-value store.
   * </pre>
   *
   * <code>optional bytes key = 1;</code>
   */
  com.google.protobuf.ByteString getKey();

  /**
   * <pre>
   * value is the value, in bytes, to associate with the key in the key-value store.
   * </pre>
   *
   * <code>optional bytes value = 2;</code>
   */
  com.google.protobuf.ByteString getValue();

  /**
   * <pre>
   * lease is the lease ID to associate with the key in the key-value store. A lease
   * value of 0 indicates no lease.
   * </pre>
   *
   * <code>optional int64 lease = 3;</code>
   */
  long getLease();

  /**
   * <pre>
   * If prev_kv is set, etcd gets the previous key-value pair before changing it.
   * The previous key-value pair will be returned in the put response.
   * </pre>
   *
   * <code>optional bool prev_kv = 4;</code>
   */
  boolean getPrevKv();
}