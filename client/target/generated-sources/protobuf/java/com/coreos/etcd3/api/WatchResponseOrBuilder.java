// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc.proto

package com.coreos.etcd3.api;

public interface WatchResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:etcdserverpb.WatchResponse)
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
   * <pre>
   * watch_id is the ID of the watcher that corresponds to the response.
   * </pre>
   *
   * <code>optional int64 watch_id = 2;</code>
   */
  long getWatchId();

  /**
   * <pre>
   * created is set to true if the response is for a create watch request.
   * The client should record the watch_id and expect to receive events for
   * the created watcher from the same stream.
   * All events sent to the created watcher will attach with the same watch_id.
   * </pre>
   *
   * <code>optional bool created = 3;</code>
   */
  boolean getCreated();

  /**
   * <pre>
   * canceled is set to true if the response is for a cancel watch request.
   * No further events will be sent to the canceled watcher.
   * </pre>
   *
   * <code>optional bool canceled = 4;</code>
   */
  boolean getCanceled();

  /**
   * <pre>
   * compact_revision is set to the minimum index if a watcher tries to watch
   * at a compacted index.
   * This happens when creating a watcher at a compacted revision or the watcher cannot
   * catch up with the progress of the key-value store. 
   * The client should treat the watcher as canceled and should not try to create any
   * watcher with the same start_revision again.
   * </pre>
   *
   * <code>optional int64 compact_revision = 5;</code>
   */
  long getCompactRevision();

  /**
   * <code>repeated .mvccpb.Event events = 11;</code>
   */
  java.util.List<mvccpb.Kv.Event> 
      getEventsList();
  /**
   * <code>repeated .mvccpb.Event events = 11;</code>
   */
  mvccpb.Kv.Event getEvents(int index);
  /**
   * <code>repeated .mvccpb.Event events = 11;</code>
   */
  int getEventsCount();
  /**
   * <code>repeated .mvccpb.Event events = 11;</code>
   */
  java.util.List<? extends mvccpb.Kv.EventOrBuilder> 
      getEventsOrBuilderList();
  /**
   * <code>repeated .mvccpb.Event events = 11;</code>
   */
  mvccpb.Kv.EventOrBuilder getEventsOrBuilder(
      int index);
}
