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
public class ClusterGrpc {

  private ClusterGrpc() {}

  public static final String SERVICE_NAME = "etcdserverpb.Cluster";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.MemberAddRequest,
      com.coreos.etcd3.api.MemberAddResponse> METHOD_MEMBER_ADD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Cluster", "MemberAdd"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.MemberAddRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.MemberAddResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.MemberRemoveRequest,
      com.coreos.etcd3.api.MemberRemoveResponse> METHOD_MEMBER_REMOVE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Cluster", "MemberRemove"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.MemberRemoveRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.MemberRemoveResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.MemberUpdateRequest,
      com.coreos.etcd3.api.MemberUpdateResponse> METHOD_MEMBER_UPDATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Cluster", "MemberUpdate"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.MemberUpdateRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.MemberUpdateResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.MemberListRequest,
      com.coreos.etcd3.api.MemberListResponse> METHOD_MEMBER_LIST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Cluster", "MemberList"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.MemberListRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.MemberListResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClusterStub newStub(io.grpc.Channel channel) {
    return new ClusterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClusterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClusterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ClusterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClusterFutureStub(channel);
  }

  /**
   */
  public static abstract class ClusterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * MemberAdd adds a member into the cluster.
     * </pre>
     */
    public void memberAdd(com.coreos.etcd3.api.MemberAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberAddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MEMBER_ADD, responseObserver);
    }

    /**
     * <pre>
     * MemberRemove removes an existing member from the cluster.
     * </pre>
     */
    public void memberRemove(com.coreos.etcd3.api.MemberRemoveRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberRemoveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MEMBER_REMOVE, responseObserver);
    }

    /**
     * <pre>
     * MemberUpdate updates the member configuration.
     * </pre>
     */
    public void memberUpdate(com.coreos.etcd3.api.MemberUpdateRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberUpdateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MEMBER_UPDATE, responseObserver);
    }

    /**
     * <pre>
     * MemberList lists all the members in the cluster.
     * </pre>
     */
    public void memberList(com.coreos.etcd3.api.MemberListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_MEMBER_LIST, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_MEMBER_ADD,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.MemberAddRequest,
                com.coreos.etcd3.api.MemberAddResponse>(
                  this, METHODID_MEMBER_ADD)))
          .addMethod(
            METHOD_MEMBER_REMOVE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.MemberRemoveRequest,
                com.coreos.etcd3.api.MemberRemoveResponse>(
                  this, METHODID_MEMBER_REMOVE)))
          .addMethod(
            METHOD_MEMBER_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.MemberUpdateRequest,
                com.coreos.etcd3.api.MemberUpdateResponse>(
                  this, METHODID_MEMBER_UPDATE)))
          .addMethod(
            METHOD_MEMBER_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.MemberListRequest,
                com.coreos.etcd3.api.MemberListResponse>(
                  this, METHODID_MEMBER_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class ClusterStub extends io.grpc.stub.AbstractStub<ClusterStub> {
    private ClusterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterStub(channel, callOptions);
    }

    /**
     * <pre>
     * MemberAdd adds a member into the cluster.
     * </pre>
     */
    public void memberAdd(com.coreos.etcd3.api.MemberAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberAddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MEMBER_ADD, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * MemberRemove removes an existing member from the cluster.
     * </pre>
     */
    public void memberRemove(com.coreos.etcd3.api.MemberRemoveRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberRemoveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MEMBER_REMOVE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * MemberUpdate updates the member configuration.
     * </pre>
     */
    public void memberUpdate(com.coreos.etcd3.api.MemberUpdateRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberUpdateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MEMBER_UPDATE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * MemberList lists all the members in the cluster.
     * </pre>
     */
    public void memberList(com.coreos.etcd3.api.MemberListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_MEMBER_LIST, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClusterBlockingStub extends io.grpc.stub.AbstractStub<ClusterBlockingStub> {
    private ClusterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * MemberAdd adds a member into the cluster.
     * </pre>
     */
    public com.coreos.etcd3.api.MemberAddResponse memberAdd(com.coreos.etcd3.api.MemberAddRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MEMBER_ADD, getCallOptions(), request);
    }

    /**
     * <pre>
     * MemberRemove removes an existing member from the cluster.
     * </pre>
     */
    public com.coreos.etcd3.api.MemberRemoveResponse memberRemove(com.coreos.etcd3.api.MemberRemoveRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MEMBER_REMOVE, getCallOptions(), request);
    }

    /**
     * <pre>
     * MemberUpdate updates the member configuration.
     * </pre>
     */
    public com.coreos.etcd3.api.MemberUpdateResponse memberUpdate(com.coreos.etcd3.api.MemberUpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MEMBER_UPDATE, getCallOptions(), request);
    }

    /**
     * <pre>
     * MemberList lists all the members in the cluster.
     * </pre>
     */
    public com.coreos.etcd3.api.MemberListResponse memberList(com.coreos.etcd3.api.MemberListRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_MEMBER_LIST, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClusterFutureStub extends io.grpc.stub.AbstractStub<ClusterFutureStub> {
    private ClusterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClusterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClusterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClusterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * MemberAdd adds a member into the cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.MemberAddResponse> memberAdd(
        com.coreos.etcd3.api.MemberAddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MEMBER_ADD, getCallOptions()), request);
    }

    /**
     * <pre>
     * MemberRemove removes an existing member from the cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.MemberRemoveResponse> memberRemove(
        com.coreos.etcd3.api.MemberRemoveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MEMBER_REMOVE, getCallOptions()), request);
    }

    /**
     * <pre>
     * MemberUpdate updates the member configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.MemberUpdateResponse> memberUpdate(
        com.coreos.etcd3.api.MemberUpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MEMBER_UPDATE, getCallOptions()), request);
    }

    /**
     * <pre>
     * MemberList lists all the members in the cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.MemberListResponse> memberList(
        com.coreos.etcd3.api.MemberListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_MEMBER_LIST, getCallOptions()), request);
    }
  }

  private static final int METHODID_MEMBER_ADD = 0;
  private static final int METHODID_MEMBER_REMOVE = 1;
  private static final int METHODID_MEMBER_UPDATE = 2;
  private static final int METHODID_MEMBER_LIST = 3;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClusterImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(ClusterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MEMBER_ADD:
          serviceImpl.memberAdd((com.coreos.etcd3.api.MemberAddRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberAddResponse>) responseObserver);
          break;
        case METHODID_MEMBER_REMOVE:
          serviceImpl.memberRemove((com.coreos.etcd3.api.MemberRemoveRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberRemoveResponse>) responseObserver);
          break;
        case METHODID_MEMBER_UPDATE:
          serviceImpl.memberUpdate((com.coreos.etcd3.api.MemberUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberUpdateResponse>) responseObserver);
          break;
        case METHODID_MEMBER_LIST:
          serviceImpl.memberList((com.coreos.etcd3.api.MemberListRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.MemberListResponse>) responseObserver);
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
        METHOD_MEMBER_ADD,
        METHOD_MEMBER_REMOVE,
        METHOD_MEMBER_UPDATE,
        METHOD_MEMBER_LIST);
  }

}
