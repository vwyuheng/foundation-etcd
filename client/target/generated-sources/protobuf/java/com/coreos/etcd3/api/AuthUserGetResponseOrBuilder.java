// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface AuthUserGetResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.AuthUserGetResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
   */
  boolean hasHeader();
  /**
   * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
   */
  com.coreos.etcd3.api.ResponseHeader getHeader();
  /**
   * <code>optional .etcdserverpb.ResponseHeader header = 1;</code>
   */
  com.coreos.etcd3.api.ResponseHeaderOrBuilder getHeaderOrBuilder();

  /**
   * <code>repeated string roles = 2;</code>
   */
  java.util.List<java.lang.String>
      getRolesList();
  /**
   * <code>repeated string roles = 2;</code>
   */
  int getRolesCount();
  /**
   * <code>repeated string roles = 2;</code>
   */
  java.lang.String getRoles(int index);
  /**
   * <code>repeated string roles = 2;</code>
   */
  com.google.protobuf.ByteString
      getRolesBytes(int index);
}
