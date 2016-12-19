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
public class LeaseGrpc {

  private LeaseGrpc() {}

  public static final String SERVICE_NAME = "etcdserverpb.Lease";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.LeaseGrantRequest,
      com.coreos.etcd3.api.LeaseGrantResponse> METHOD_LEASE_GRANT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Lease", "LeaseGrant"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.LeaseGrantRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.LeaseGrantResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.LeaseRevokeRequest,
      com.coreos.etcd3.api.LeaseRevokeResponse> METHOD_LEASE_REVOKE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Lease", "LeaseRevoke"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.LeaseRevokeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.LeaseRevokeResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.LeaseKeepAliveRequest,
      com.coreos.etcd3.api.LeaseKeepAliveResponse> METHOD_LEASE_KEEP_ALIVE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "etcdserverpb.Lease", "LeaseKeepAlive"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.LeaseKeepAliveRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.LeaseKeepAliveResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LeaseStub newStub(io.grpc.Channel channel) {
    return new LeaseStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LeaseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LeaseBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static LeaseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LeaseFutureStub(channel);
  }

  /**
   */
  public static abstract class LeaseImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public void leaseGrant(com.coreos.etcd3.api.LeaseGrantRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseGrantResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LEASE_GRANT, responseObserver);
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public void leaseRevoke(com.coreos.etcd3.api.LeaseRevokeRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseRevokeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LEASE_REVOKE, responseObserver);
    }

    /**
     * <pre>
     * LeaseKeepAlive keeps the lease alive by streaming keep alive requests from the client
     * to the server and streaming keep alive responses from the server to the client.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseKeepAliveRequest> leaseKeepAlive(
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseKeepAliveResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_LEASE_KEEP_ALIVE, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LEASE_GRANT,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.LeaseGrantRequest,
                com.coreos.etcd3.api.LeaseGrantResponse>(
                  this, METHODID_LEASE_GRANT)))
          .addMethod(
            METHOD_LEASE_REVOKE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.LeaseRevokeRequest,
                com.coreos.etcd3.api.LeaseRevokeResponse>(
                  this, METHODID_LEASE_REVOKE)))
          .addMethod(
            METHOD_LEASE_KEEP_ALIVE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.coreos.etcd3.api.LeaseKeepAliveRequest,
                com.coreos.etcd3.api.LeaseKeepAliveResponse>(
                  this, METHODID_LEASE_KEEP_ALIVE)))
          .build();
    }
  }

  /**
   */
  public static final class LeaseStub extends io.grpc.stub.AbstractStub<LeaseStub> {
    private LeaseStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaseStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaseStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaseStub(channel, callOptions);
    }

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public void leaseGrant(com.coreos.etcd3.api.LeaseGrantRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseGrantResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LEASE_GRANT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public void leaseRevoke(com.coreos.etcd3.api.LeaseRevokeRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseRevokeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LEASE_REVOKE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * LeaseKeepAlive keeps the lease alive by streaming keep alive requests from the client
     * to the server and streaming keep alive responses from the server to the client.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseKeepAliveRequest> leaseKeepAlive(
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseKeepAliveResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_LEASE_KEEP_ALIVE, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class LeaseBlockingStub extends io.grpc.stub.AbstractStub<LeaseBlockingStub> {
    private LeaseBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaseBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaseBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaseBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public com.coreos.etcd3.api.LeaseGrantResponse leaseGrant(com.coreos.etcd3.api.LeaseGrantRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LEASE_GRANT, getCallOptions(), request);
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public com.coreos.etcd3.api.LeaseRevokeResponse leaseRevoke(com.coreos.etcd3.api.LeaseRevokeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LEASE_REVOKE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LeaseFutureStub extends io.grpc.stub.AbstractStub<LeaseFutureStub> {
    private LeaseFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaseFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaseFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaseFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.LeaseGrantResponse> leaseGrant(
        com.coreos.etcd3.api.LeaseGrantRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LEASE_GRANT, getCallOptions()), request);
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.LeaseRevokeResponse> leaseRevoke(
        com.coreos.etcd3.api.LeaseRevokeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LEASE_REVOKE, getCallOptions()), request);
    }
  }

  private static final int METHODID_LEASE_GRANT = 0;
  private static final int METHODID_LEASE_REVOKE = 1;
  private static final int METHODID_LEASE_KEEP_ALIVE = 2;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LeaseImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(LeaseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LEASE_GRANT:
          serviceImpl.leaseGrant((com.coreos.etcd3.api.LeaseGrantRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseGrantResponse>) responseObserver);
          break;
        case METHODID_LEASE_REVOKE:
          serviceImpl.leaseRevoke((com.coreos.etcd3.api.LeaseRevokeRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseRevokeResponse>) responseObserver);
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
        case METHODID_LEASE_KEEP_ALIVE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.leaseKeepAlive(
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.LeaseKeepAliveResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_LEASE_GRANT,
        METHOD_LEASE_REVOKE,
        METHOD_LEASE_KEEP_ALIVE);
  }

}
