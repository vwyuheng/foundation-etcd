// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface WatchRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.WatchRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .etcdserverpb.WatchCreateRequest create_request = 1;</code>
   */
  com.coreos.etcd3.api.WatchCreateRequest getCreateRequest();
  /**
   * <code>optional .etcdserverpb.WatchCreateRequest create_request = 1;</code>
   */
  com.coreos.etcd3.api.WatchCreateRequestOrBuilder getCreateRequestOrBuilder();

  /**
   * <code>optional .etcdserverpb.WatchCancelRequest cancel_request = 2;</code>
   */
  com.coreos.etcd3.api.WatchCancelRequest getCancelRequest();
  /**
   * <code>optional .etcdserverpb.WatchCancelRequest cancel_request = 2;</code>
   */
  com.coreos.etcd3.api.WatchCancelRequestOrBuilder getCancelRequestOrBuilder();

  public com.coreos.etcd3.api.WatchRequest.RequestUnionCase getRequestUnionCase();
}
