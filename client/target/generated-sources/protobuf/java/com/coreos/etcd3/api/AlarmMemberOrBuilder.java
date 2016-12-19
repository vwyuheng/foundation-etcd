// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface AlarmMemberOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.AlarmMember)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * memberID is the ID of the member associated with the raised alarm.
   * </pre>
   *
   * <code>optional uint64 memberID = 1;</code>
   */
  long getMemberID();

  /**
   * <pre>
   * alarm is the type of alarm which has been raised.
   * </pre>
   *
   * <code>optional .etcdserverpb.AlarmType alarm = 2;</code>
   */
  int getAlarmValue();
  /**
   * <pre>
   * alarm is the type of alarm which has been raised.
   * </pre>
   *
   * <code>optional .etcdserverpb.AlarmType alarm = 2;</code>
   */
  com.coreos.etcd3.api.AlarmType getAlarm();
}