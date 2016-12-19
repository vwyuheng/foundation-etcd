// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface AuthRoleGetResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.AuthRoleGetResponse)
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
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  java.util.List<authpb.Auth.Permission> 
      getPermList();
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  authpb.Auth.Permission getPerm(int index);
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  int getPermCount();
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  java.util.List<? extends authpb.Auth.PermissionOrBuilder> 
      getPermOrBuilderList();
  /**
   * <code>repeated .authpb.Permission perm = 2;</code>
   */
  authpb.Auth.PermissionOrBuilder getPermOrBuilder(
      int index);
}
