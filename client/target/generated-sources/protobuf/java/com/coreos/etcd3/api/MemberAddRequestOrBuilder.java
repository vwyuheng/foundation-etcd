// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface MemberAddRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.MemberAddRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * peerURLs is the list of URLs the added member will use to communicate with the cluster.
   * </pre>
   *
   * <code>repeated string peerURLs = 1;</code>
   */
  java.util.List<java.lang.String>
      getPeerURLsList();
  /**
   * <pre>
   * peerURLs is the list of URLs the added member will use to communicate with the cluster.
   * </pre>
   *
   * <code>repeated string peerURLs = 1;</code>
   */
  int getPeerURLsCount();
  /**
   * <pre>
   * peerURLs is the list of URLs the added member will use to communicate with the cluster.
   * </pre>
   *
   * <code>repeated string peerURLs = 1;</code>
   */
  java.lang.String getPeerURLs(int index);
  /**
   * <pre>
   * peerURLs is the list of URLs the added member will use to communicate with the cluster.
   * </pre>
   *
   * <code>repeated string peerURLs = 1;</code>
   */
  com.google.protobuf.ByteString
      getPeerURLsBytes(int index);
}
