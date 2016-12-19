package com.coreos.etcd3.api;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.1)",
    comments = "Source: rpc.proto")
public class MaintenanceGrpc {

  private MaintenanceGrpc() {}

  public static final String SERVICE_NAME = "etcdserverpb.Maintenance";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AlarmRequest,
      com.coreos.etcd3.api.AlarmResponse> METHOD_ALARM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Alarm"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AlarmRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AlarmResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.StatusRequest,
      com.coreos.etcd3.api.StatusResponse> METHOD_STATUS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Status"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.StatusRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.StatusResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.DefragmentRequest,
      com.coreos.etcd3.api.DefragmentResponse> METHOD_DEFRAGMENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Defragment"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.DefragmentRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.DefragmentResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.HashRequest,
      com.coreos.etcd3.api.HashResponse> METHOD_HASH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Hash"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.HashRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.HashResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.SnapshotRequest,
      com.coreos.etcd3.api.SnapshotResponse> METHOD_SNAPSHOT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Snapshot"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.SnapshotRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.SnapshotResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MaintenanceStub newStub(io.grpc.Channel channel) {
    return new MaintenanceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MaintenanceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MaintenanceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static MaintenanceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MaintenanceFutureStub(channel);
  }

  /**
   */
  public static abstract class MaintenanceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public void alarm(com.coreos.etcd3.api.AlarmRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AlarmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ALARM, responseObserver);
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public void status(com.coreos.etcd3.api.StatusRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_STATUS, responseObserver);
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public void defragment(com.coreos.etcd3.api.DefragmentRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.DefragmentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DEFRAGMENT, responseObserver);
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public void hash(com.coreos.etcd3.api.HashRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.HashResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_HASH, responseObserver);
    }

    /**
     * <pre>
     * Snapshot sends a snapshot of the entire backend from a member over a stream to a client.
     * </pre>
     */
    public void snapshot(com.coreos.etcd3.api.SnapshotRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.SnapshotResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SNAPSHOT, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ALARM,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AlarmRequest,
                com.coreos.etcd3.api.AlarmResponse>(
                  this, METHODID_ALARM)))
          .addMethod(
            METHOD_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.StatusRequest,
                com.coreos.etcd3.api.StatusResponse>(
                  this, METHODID_STATUS)))
          .addMethod(
            METHOD_DEFRAGMENT,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.DefragmentRequest,
                com.coreos.etcd3.api.DefragmentResponse>(
                  this, METHODID_DEFRAGMENT)))
          .addMethod(
            METHOD_HASH,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.HashRequest,
                com.coreos.etcd3.api.HashResponse>(
                  this, METHODID_HASH)))
          .addMethod(
            METHOD_SNAPSHOT,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.coreos.etcd3.api.SnapshotRequest,
                com.coreos.etcd3.api.SnapshotResponse>(
                  this, METHODID_SNAPSHOT)))
          .build();
    }
  }

  /**
   */
  public static final class MaintenanceStub extends io.grpc.stub.AbstractStub<MaintenanceStub> {
    private MaintenanceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaintenanceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaintenanceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public void alarm(com.coreos.etcd3.api.AlarmRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AlarmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ALARM, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public void status(com.coreos.etcd3.api.StatusRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_STATUS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public void defragment(com.coreos.etcd3.api.DefragmentRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.DefragmentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DEFRAGMENT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public void hash(com.coreos.etcd3.api.HashRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.HashResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_HASH, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Snapshot sends a snapshot of the entire backend from a member over a stream to a client.
     * </pre>
     */
    public void snapshot(com.coreos.etcd3.api.SnapshotRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.SnapshotResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SNAPSHOT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MaintenanceBlockingStub extends io.grpc.stub.AbstractStub<MaintenanceBlockingStub> {
    private MaintenanceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaintenanceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaintenanceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public com.coreos.etcd3.api.AlarmResponse alarm(com.coreos.etcd3.api.AlarmRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ALARM, getCallOptions(), request);
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public com.coreos.etcd3.api.StatusResponse status(com.coreos.etcd3.api.StatusRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_STATUS, getCallOptions(), request);
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public com.coreos.etcd3.api.DefragmentResponse defragment(com.coreos.etcd3.api.DefragmentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DEFRAGMENT, getCallOptions(), request);
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public com.coreos.etcd3.api.HashResponse hash(com.coreos.etcd3.api.HashRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_HASH, getCallOptions(), request);
    }

    /**
     * <pre>
     * Snapshot sends a snapshot of the entire backend from a member over a stream to a client.
     * </pre>
     */
    public java.util.Iterator<com.coreos.etcd3.api.SnapshotResponse> snapshot(
        com.coreos.etcd3.api.SnapshotRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SNAPSHOT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MaintenanceFutureStub extends io.grpc.stub.AbstractStub<MaintenanceFutureStub> {
    private MaintenanceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaintenanceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaintenanceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AlarmResponse> alarm(
        com.coreos.etcd3.api.AlarmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ALARM, getCallOptions()), request);
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.StatusResponse> status(
        com.coreos.etcd3.api.StatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_STATUS, getCallOptions()), request);
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.DefragmentResponse> defragment(
        com.coreos.etcd3.api.DefragmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DEFRAGMENT, getCallOptions()), request);
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.HashResponse> hash(
        com.coreos.etcd3.api.HashRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_HASH, getCallOptions()), request);
    }
  }

  private static final int METHODID_ALARM = 0;
  private static final int METHODID_STATUS = 1;
  private static final int METHODID_DEFRAGMENT = 2;
  private static final int METHODID_HASH = 3;
  private static final int METHODID_SNAPSHOT = 4;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MaintenanceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(MaintenanceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALARM:
          serviceImpl.alarm((com.coreos.etcd3.api.AlarmRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AlarmResponse>) responseObserver);
          break;
        case METHODID_STATUS:
          serviceImpl.status((com.coreos.etcd3.api.StatusRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.StatusResponse>) responseObserver);
          break;
        case METHODID_DEFRAGMENT:
          serviceImpl.defragment((com.coreos.etcd3.api.DefragmentRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.DefragmentResponse>) responseObserver);
          break;
        case METHODID_HASH:
          serviceImpl.hash((com.coreos.etcd3.api.HashRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.HashResponse>) responseObserver);
          break;
        case METHODID_SNAPSHOT:
          serviceImpl.snapshot((com.coreos.etcd3.api.SnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.SnapshotResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_ALARM,
        METHOD_STATUS,
        METHOD_DEFRAGMENT,
        METHOD_HASH,
        METHOD_SNAPSHOT);
  }

}
