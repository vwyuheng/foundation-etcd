// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface AuthRoleRevokePermissionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.AuthRoleRevokePermissionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional string role = 1;</code>
   */
  java.lang.String getRole();
  /**
   * <code>optional string role = 1;</code>
   */
  com.google.protobuf.ByteString
      getRoleBytes();

  /**
   * <code>optional string key = 2;</code>
   */
  java.lang.String getKey();
  /**
   * <code>optional string key = 2;</code>
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <code>optional string range_end = 3;</code>
   */
  java.lang.String getRangeEnd();
  /**
   * <code>optional string range_end = 3;</code>
   */
  com.google.protobuf.ByteString
      getRangeEndBytes();
}