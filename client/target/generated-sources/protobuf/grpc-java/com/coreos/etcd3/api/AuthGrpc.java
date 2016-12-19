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
public class AuthGrpc {

  private AuthGrpc() {}

  public static final String SERVICE_NAME = "etcdserverpb.Auth";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthEnableRequest,
      com.coreos.etcd3.api.AuthEnableResponse> METHOD_AUTH_ENABLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "AuthEnable"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthEnableRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthEnableResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthDisableRequest,
      com.coreos.etcd3.api.AuthDisableResponse> METHOD_AUTH_DISABLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "AuthDisable"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthDisableRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthDisableResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthenticateRequest,
      com.coreos.etcd3.api.AuthenticateResponse> METHOD_AUTHENTICATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "Authenticate"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthenticateRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthenticateResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthUserAddRequest,
      com.coreos.etcd3.api.AuthUserAddResponse> METHOD_USER_ADD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserAdd"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserAddRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserAddResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthUserGetRequest,
      com.coreos.etcd3.api.AuthUserGetResponse> METHOD_USER_GET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserGet"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserGetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserGetResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthUserListRequest,
      com.coreos.etcd3.api.AuthUserListResponse> METHOD_USER_LIST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserList"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserListRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserListResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthUserDeleteRequest,
      com.coreos.etcd3.api.AuthUserDeleteResponse> METHOD_USER_DELETE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserDelete"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserDeleteRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserDeleteResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthUserChangePasswordRequest,
      com.coreos.etcd3.api.AuthUserChangePasswordResponse> METHOD_USER_CHANGE_PASSWORD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserChangePassword"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserChangePasswordRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserChangePasswordResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthUserGrantRoleRequest,
      com.coreos.etcd3.api.AuthUserGrantRoleResponse> METHOD_USER_GRANT_ROLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserGrantRole"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserGrantRoleRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserGrantRoleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthUserRevokeRoleRequest,
      com.coreos.etcd3.api.AuthUserRevokeRoleResponse> METHOD_USER_REVOKE_ROLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserRevokeRole"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserRevokeRoleRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthUserRevokeRoleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthRoleAddRequest,
      com.coreos.etcd3.api.AuthRoleAddResponse> METHOD_ROLE_ADD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleAdd"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleAddRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleAddResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthRoleGetRequest,
      com.coreos.etcd3.api.AuthRoleGetResponse> METHOD_ROLE_GET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleGet"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleGetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleGetResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthRoleListRequest,
      com.coreos.etcd3.api.AuthRoleListResponse> METHOD_ROLE_LIST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleList"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleListRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleListResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthRoleDeleteRequest,
      com.coreos.etcd3.api.AuthRoleDeleteResponse> METHOD_ROLE_DELETE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleDelete"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleDeleteRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleDeleteResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthRoleGrantPermissionRequest,
      com.coreos.etcd3.api.AuthRoleGrantPermissionResponse> METHOD_ROLE_GRANT_PERMISSION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleGrantPermission"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleGrantPermissionRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleGrantPermissionResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.etcd3.api.AuthRoleRevokePermissionRequest,
      com.coreos.etcd3.api.AuthRoleRevokePermissionResponse> METHOD_ROLE_REVOKE_PERMISSION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleRevokePermission"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleRevokePermissionRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.etcd3.api.AuthRoleRevokePermissionResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthStub newStub(io.grpc.Channel channel) {
    return new AuthStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static AuthFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthFutureStub(channel);
  }

  /**
   */
  public static abstract class AuthImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public void authEnable(com.coreos.etcd3.api.AuthEnableRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthEnableResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AUTH_ENABLE, responseObserver);
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public void authDisable(com.coreos.etcd3.api.AuthDisableRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthDisableResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AUTH_DISABLE, responseObserver);
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public void authenticate(com.coreos.etcd3.api.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthenticateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AUTHENTICATE, responseObserver);
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public void userAdd(com.coreos.etcd3.api.AuthUserAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserAddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_ADD, responseObserver);
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public void userGet(com.coreos.etcd3.api.AuthUserGetRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserGetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_GET, responseObserver);
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public void userList(com.coreos.etcd3.api.AuthUserListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_LIST, responseObserver);
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public void userDelete(com.coreos.etcd3.api.AuthUserDeleteRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserDeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_DELETE, responseObserver);
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public void userChangePassword(com.coreos.etcd3.api.AuthUserChangePasswordRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserChangePasswordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_CHANGE_PASSWORD, responseObserver);
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public void userGrantRole(com.coreos.etcd3.api.AuthUserGrantRoleRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserGrantRoleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_GRANT_ROLE, responseObserver);
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public void userRevokeRole(com.coreos.etcd3.api.AuthUserRevokeRoleRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserRevokeRoleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_REVOKE_ROLE, responseObserver);
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public void roleAdd(com.coreos.etcd3.api.AuthRoleAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleAddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_ADD, responseObserver);
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public void roleGet(com.coreos.etcd3.api.AuthRoleGetRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleGetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_GET, responseObserver);
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public void roleList(com.coreos.etcd3.api.AuthRoleListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_LIST, responseObserver);
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public void roleDelete(com.coreos.etcd3.api.AuthRoleDeleteRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleDeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_DELETE, responseObserver);
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public void roleGrantPermission(com.coreos.etcd3.api.AuthRoleGrantPermissionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleGrantPermissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_GRANT_PERMISSION, responseObserver);
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public void roleRevokePermission(com.coreos.etcd3.api.AuthRoleRevokePermissionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleRevokePermissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_REVOKE_PERMISSION, responseObserver);
    }

    @java.lang.Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_AUTH_ENABLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthEnableRequest,
                com.coreos.etcd3.api.AuthEnableResponse>(
                  this, METHODID_AUTH_ENABLE)))
          .addMethod(
            METHOD_AUTH_DISABLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthDisableRequest,
                com.coreos.etcd3.api.AuthDisableResponse>(
                  this, METHODID_AUTH_DISABLE)))
          .addMethod(
            METHOD_AUTHENTICATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthenticateRequest,
                com.coreos.etcd3.api.AuthenticateResponse>(
                  this, METHODID_AUTHENTICATE)))
          .addMethod(
            METHOD_USER_ADD,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthUserAddRequest,
                com.coreos.etcd3.api.AuthUserAddResponse>(
                  this, METHODID_USER_ADD)))
          .addMethod(
            METHOD_USER_GET,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthUserGetRequest,
                com.coreos.etcd3.api.AuthUserGetResponse>(
                  this, METHODID_USER_GET)))
          .addMethod(
            METHOD_USER_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthUserListRequest,
                com.coreos.etcd3.api.AuthUserListResponse>(
                  this, METHODID_USER_LIST)))
          .addMethod(
            METHOD_USER_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthUserDeleteRequest,
                com.coreos.etcd3.api.AuthUserDeleteResponse>(
                  this, METHODID_USER_DELETE)))
          .addMethod(
            METHOD_USER_CHANGE_PASSWORD,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthUserChangePasswordRequest,
                com.coreos.etcd3.api.AuthUserChangePasswordResponse>(
                  this, METHODID_USER_CHANGE_PASSWORD)))
          .addMethod(
            METHOD_USER_GRANT_ROLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthUserGrantRoleRequest,
                com.coreos.etcd3.api.AuthUserGrantRoleResponse>(
                  this, METHODID_USER_GRANT_ROLE)))
          .addMethod(
            METHOD_USER_REVOKE_ROLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthUserRevokeRoleRequest,
                com.coreos.etcd3.api.AuthUserRevokeRoleResponse>(
                  this, METHODID_USER_REVOKE_ROLE)))
          .addMethod(
            METHOD_ROLE_ADD,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthRoleAddRequest,
                com.coreos.etcd3.api.AuthRoleAddResponse>(
                  this, METHODID_ROLE_ADD)))
          .addMethod(
            METHOD_ROLE_GET,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthRoleGetRequest,
                com.coreos.etcd3.api.AuthRoleGetResponse>(
                  this, METHODID_ROLE_GET)))
          .addMethod(
            METHOD_ROLE_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthRoleListRequest,
                com.coreos.etcd3.api.AuthRoleListResponse>(
                  this, METHODID_ROLE_LIST)))
          .addMethod(
            METHOD_ROLE_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthRoleDeleteRequest,
                com.coreos.etcd3.api.AuthRoleDeleteResponse>(
                  this, METHODID_ROLE_DELETE)))
          .addMethod(
            METHOD_ROLE_GRANT_PERMISSION,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthRoleGrantPermissionRequest,
                com.coreos.etcd3.api.AuthRoleGrantPermissionResponse>(
                  this, METHODID_ROLE_GRANT_PERMISSION)))
          .addMethod(
            METHOD_ROLE_REVOKE_PERMISSION,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.etcd3.api.AuthRoleRevokePermissionRequest,
                com.coreos.etcd3.api.AuthRoleRevokePermissionResponse>(
                  this, METHODID_ROLE_REVOKE_PERMISSION)))
          .build();
    }
  }

  /**
   */
  public static final class AuthStub extends io.grpc.stub.AbstractStub<AuthStub> {
    private AuthStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthStub(channel, callOptions);
    }

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public void authEnable(com.coreos.etcd3.api.AuthEnableRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthEnableResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTH_ENABLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public void authDisable(com.coreos.etcd3.api.AuthDisableRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthDisableResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTH_DISABLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public void authenticate(com.coreos.etcd3.api.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthenticateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTHENTICATE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public void userAdd(com.coreos.etcd3.api.AuthUserAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserAddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_ADD, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public void userGet(com.coreos.etcd3.api.AuthUserGetRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserGetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_GET, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public void userList(com.coreos.etcd3.api.AuthUserListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public void userDelete(com.coreos.etcd3.api.AuthUserDeleteRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserDeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public void userChangePassword(com.coreos.etcd3.api.AuthUserChangePasswordRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserChangePasswordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_CHANGE_PASSWORD, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public void userGrantRole(com.coreos.etcd3.api.AuthUserGrantRoleRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserGrantRoleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_GRANT_ROLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public void userRevokeRole(com.coreos.etcd3.api.AuthUserRevokeRoleRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserRevokeRoleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_REVOKE_ROLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public void roleAdd(com.coreos.etcd3.api.AuthRoleAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleAddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_ADD, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public void roleGet(com.coreos.etcd3.api.AuthRoleGetRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleGetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_GET, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public void roleList(com.coreos.etcd3.api.AuthRoleListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public void roleDelete(com.coreos.etcd3.api.AuthRoleDeleteRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleDeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public void roleGrantPermission(com.coreos.etcd3.api.AuthRoleGrantPermissionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleGrantPermissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_GRANT_PERMISSION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public void roleRevokePermission(com.coreos.etcd3.api.AuthRoleRevokePermissionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleRevokePermissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_REVOKE_PERMISSION, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthBlockingStub extends io.grpc.stub.AbstractStub<AuthBlockingStub> {
    private AuthBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthEnableResponse authEnable(com.coreos.etcd3.api.AuthEnableRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AUTH_ENABLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthDisableResponse authDisable(com.coreos.etcd3.api.AuthDisableRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AUTH_DISABLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthenticateResponse authenticate(com.coreos.etcd3.api.AuthenticateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AUTHENTICATE, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthUserAddResponse userAdd(com.coreos.etcd3.api.AuthUserAddRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_ADD, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthUserGetResponse userGet(com.coreos.etcd3.api.AuthUserGetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_GET, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthUserListResponse userList(com.coreos.etcd3.api.AuthUserListRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_LIST, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthUserDeleteResponse userDelete(com.coreos.etcd3.api.AuthUserDeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_DELETE, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthUserChangePasswordResponse userChangePassword(com.coreos.etcd3.api.AuthUserChangePasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_CHANGE_PASSWORD, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthUserGrantRoleResponse userGrantRole(com.coreos.etcd3.api.AuthUserGrantRoleRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_GRANT_ROLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthUserRevokeRoleResponse userRevokeRole(com.coreos.etcd3.api.AuthUserRevokeRoleRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_REVOKE_ROLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthRoleAddResponse roleAdd(com.coreos.etcd3.api.AuthRoleAddRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_ADD, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthRoleGetResponse roleGet(com.coreos.etcd3.api.AuthRoleGetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_GET, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthRoleListResponse roleList(com.coreos.etcd3.api.AuthRoleListRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_LIST, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthRoleDeleteResponse roleDelete(com.coreos.etcd3.api.AuthRoleDeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_DELETE, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthRoleGrantPermissionResponse roleGrantPermission(com.coreos.etcd3.api.AuthRoleGrantPermissionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_GRANT_PERMISSION, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public com.coreos.etcd3.api.AuthRoleRevokePermissionResponse roleRevokePermission(com.coreos.etcd3.api.AuthRoleRevokePermissionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_REVOKE_PERMISSION, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthFutureStub extends io.grpc.stub.AbstractStub<AuthFutureStub> {
    private AuthFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthEnableResponse> authEnable(
        com.coreos.etcd3.api.AuthEnableRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AUTH_ENABLE, getCallOptions()), request);
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthDisableResponse> authDisable(
        com.coreos.etcd3.api.AuthDisableRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AUTH_DISABLE, getCallOptions()), request);
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthenticateResponse> authenticate(
        com.coreos.etcd3.api.AuthenticateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AUTHENTICATE, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthUserAddResponse> userAdd(
        com.coreos.etcd3.api.AuthUserAddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_ADD, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthUserGetResponse> userGet(
        com.coreos.etcd3.api.AuthUserGetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_GET, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthUserListResponse> userList(
        com.coreos.etcd3.api.AuthUserListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_LIST, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthUserDeleteResponse> userDelete(
        com.coreos.etcd3.api.AuthUserDeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_DELETE, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthUserChangePasswordResponse> userChangePassword(
        com.coreos.etcd3.api.AuthUserChangePasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_CHANGE_PASSWORD, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthUserGrantRoleResponse> userGrantRole(
        com.coreos.etcd3.api.AuthUserGrantRoleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_GRANT_ROLE, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthUserRevokeRoleResponse> userRevokeRole(
        com.coreos.etcd3.api.AuthUserRevokeRoleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_REVOKE_ROLE, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthRoleAddResponse> roleAdd(
        com.coreos.etcd3.api.AuthRoleAddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_ADD, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthRoleGetResponse> roleGet(
        com.coreos.etcd3.api.AuthRoleGetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_GET, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthRoleListResponse> roleList(
        com.coreos.etcd3.api.AuthRoleListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_LIST, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthRoleDeleteResponse> roleDelete(
        com.coreos.etcd3.api.AuthRoleDeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_DELETE, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthRoleGrantPermissionResponse> roleGrantPermission(
        com.coreos.etcd3.api.AuthRoleGrantPermissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_GRANT_PERMISSION, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.etcd3.api.AuthRoleRevokePermissionResponse> roleRevokePermission(
        com.coreos.etcd3.api.AuthRoleRevokePermissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_REVOKE_PERMISSION, getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTH_ENABLE = 0;
  private static final int METHODID_AUTH_DISABLE = 1;
  private static final int METHODID_AUTHENTICATE = 2;
  private static final int METHODID_USER_ADD = 3;
  private static final int METHODID_USER_GET = 4;
  private static final int METHODID_USER_LIST = 5;
  private static final int METHODID_USER_DELETE = 6;
  private static final int METHODID_USER_CHANGE_PASSWORD = 7;
  private static final int METHODID_USER_GRANT_ROLE = 8;
  private static final int METHODID_USER_REVOKE_ROLE = 9;
  private static final int METHODID_ROLE_ADD = 10;
  private static final int METHODID_ROLE_GET = 11;
  private static final int METHODID_ROLE_LIST = 12;
  private static final int METHODID_ROLE_DELETE = 13;
  private static final int METHODID_ROLE_GRANT_PERMISSION = 14;
  private static final int METHODID_ROLE_REVOKE_PERMISSION = 15;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(AuthImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTH_ENABLE:
          serviceImpl.authEnable((com.coreos.etcd3.api.AuthEnableRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthEnableResponse>) responseObserver);
          break;
        case METHODID_AUTH_DISABLE:
          serviceImpl.authDisable((com.coreos.etcd3.api.AuthDisableRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthDisableResponse>) responseObserver);
          break;
        case METHODID_AUTHENTICATE:
          serviceImpl.authenticate((com.coreos.etcd3.api.AuthenticateRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthenticateResponse>) responseObserver);
          break;
        case METHODID_USER_ADD:
          serviceImpl.userAdd((com.coreos.etcd3.api.AuthUserAddRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserAddResponse>) responseObserver);
          break;
        case METHODID_USER_GET:
          serviceImpl.userGet((com.coreos.etcd3.api.AuthUserGetRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserGetResponse>) responseObserver);
          break;
        case METHODID_USER_LIST:
          serviceImpl.userList((com.coreos.etcd3.api.AuthUserListRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserListResponse>) responseObserver);
          break;
        case METHODID_USER_DELETE:
          serviceImpl.userDelete((com.coreos.etcd3.api.AuthUserDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserDeleteResponse>) responseObserver);
          break;
        case METHODID_USER_CHANGE_PASSWORD:
          serviceImpl.userChangePassword((com.coreos.etcd3.api.AuthUserChangePasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserChangePasswordResponse>) responseObserver);
          break;
        case METHODID_USER_GRANT_ROLE:
          serviceImpl.userGrantRole((com.coreos.etcd3.api.AuthUserGrantRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserGrantRoleResponse>) responseObserver);
          break;
        case METHODID_USER_REVOKE_ROLE:
          serviceImpl.userRevokeRole((com.coreos.etcd3.api.AuthUserRevokeRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthUserRevokeRoleResponse>) responseObserver);
          break;
        case METHODID_ROLE_ADD:
          serviceImpl.roleAdd((com.coreos.etcd3.api.AuthRoleAddRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleAddResponse>) responseObserver);
          break;
        case METHODID_ROLE_GET:
          serviceImpl.roleGet((com.coreos.etcd3.api.AuthRoleGetRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleGetResponse>) responseObserver);
          break;
        case METHODID_ROLE_LIST:
          serviceImpl.roleList((com.coreos.etcd3.api.AuthRoleListRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleListResponse>) responseObserver);
          break;
        case METHODID_ROLE_DELETE:
          serviceImpl.roleDelete((com.coreos.etcd3.api.AuthRoleDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleDeleteResponse>) responseObserver);
          break;
        case METHODID_ROLE_GRANT_PERMISSION:
          serviceImpl.roleGrantPermission((com.coreos.etcd3.api.AuthRoleGrantPermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleGrantPermissionResponse>) responseObserver);
          break;
        case METHODID_ROLE_REVOKE_PERMISSION:
          serviceImpl.roleRevokePermission((com.coreos.etcd3.api.AuthRoleRevokePermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.etcd3.api.AuthRoleRevokePermissionResponse>) responseObserver);
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
        METHOD_AUTH_ENABLE,
        METHOD_AUTH_DISABLE,
        METHOD_AUTHENTICATE,
        METHOD_USER_ADD,
        METHOD_USER_GET,
        METHOD_USER_LIST,
        METHOD_USER_DELETE,
        METHOD_USER_CHANGE_PASSWORD,
        METHOD_USER_GRANT_ROLE,
        METHOD_USER_REVOKE_ROLE,
        METHOD_ROLE_ADD,
        METHOD_ROLE_GET,
        METHOD_ROLE_LIST,
        METHOD_ROLE_DELETE,
        METHOD_ROLE_GRANT_PERMISSION,
        METHOD_ROLE_REVOKE_PERMISSION);
  }

}
