package com.models.sec05;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.0)",
    comments = "Source: sec05/bank_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BankServiceGrpc {

  private BankServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "sec05.BankService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.models.sec05.BalanceCheckReq,
      com.models.sec05.BalanceCheckResp> getGetAccountBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAccountBalance",
      requestType = com.models.sec05.BalanceCheckReq.class,
      responseType = com.models.sec05.BalanceCheckResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.models.sec05.BalanceCheckReq,
      com.models.sec05.BalanceCheckResp> getGetAccountBalanceMethod() {
    io.grpc.MethodDescriptor<com.models.sec05.BalanceCheckReq, com.models.sec05.BalanceCheckResp> getGetAccountBalanceMethod;
    if ((getGetAccountBalanceMethod = BankServiceGrpc.getGetAccountBalanceMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getGetAccountBalanceMethod = BankServiceGrpc.getGetAccountBalanceMethod) == null) {
          BankServiceGrpc.getGetAccountBalanceMethod = getGetAccountBalanceMethod =
              io.grpc.MethodDescriptor.<com.models.sec05.BalanceCheckReq, com.models.sec05.BalanceCheckResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAccountBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.BalanceCheckReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.BalanceCheckResp.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("getAccountBalance"))
              .build();
        }
      }
    }
    return getGetAccountBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.models.sec05.AllAccountsResp> getGetAllAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllAccounts",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.models.sec05.AllAccountsResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.models.sec05.AllAccountsResp> getGetAllAccountsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.models.sec05.AllAccountsResp> getGetAllAccountsMethod;
    if ((getGetAllAccountsMethod = BankServiceGrpc.getGetAllAccountsMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getGetAllAccountsMethod = BankServiceGrpc.getGetAllAccountsMethod) == null) {
          BankServiceGrpc.getGetAllAccountsMethod = getGetAllAccountsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.models.sec05.AllAccountsResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.AllAccountsResp.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("GetAllAccounts"))
              .build();
        }
      }
    }
    return getGetAllAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.models.sec05.WithdrawReq,
      com.models.sec05.Money> getWithdrawMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Withdraw",
      requestType = com.models.sec05.WithdrawReq.class,
      responseType = com.models.sec05.Money.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.models.sec05.WithdrawReq,
      com.models.sec05.Money> getWithdrawMethod() {
    io.grpc.MethodDescriptor<com.models.sec05.WithdrawReq, com.models.sec05.Money> getWithdrawMethod;
    if ((getWithdrawMethod = BankServiceGrpc.getWithdrawMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getWithdrawMethod = BankServiceGrpc.getWithdrawMethod) == null) {
          BankServiceGrpc.getWithdrawMethod = getWithdrawMethod =
              io.grpc.MethodDescriptor.<com.models.sec05.WithdrawReq, com.models.sec05.Money>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Withdraw"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.WithdrawReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.Money.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("Withdraw"))
              .build();
        }
      }
    }
    return getWithdrawMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.models.sec05.DepositRequest,
      com.models.sec05.BalanceCheckResp> getDepositMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Deposit",
      requestType = com.models.sec05.DepositRequest.class,
      responseType = com.models.sec05.BalanceCheckResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.models.sec05.DepositRequest,
      com.models.sec05.BalanceCheckResp> getDepositMethod() {
    io.grpc.MethodDescriptor<com.models.sec05.DepositRequest, com.models.sec05.BalanceCheckResp> getDepositMethod;
    if ((getDepositMethod = BankServiceGrpc.getDepositMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getDepositMethod = BankServiceGrpc.getDepositMethod) == null) {
          BankServiceGrpc.getDepositMethod = getDepositMethod =
              io.grpc.MethodDescriptor.<com.models.sec05.DepositRequest, com.models.sec05.BalanceCheckResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Deposit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.DepositRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.BalanceCheckResp.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("Deposit"))
              .build();
        }
      }
    }
    return getDepositMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.models.sec05.TransferReq,
      com.models.sec05.TransferResp> getTransferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Transfer",
      requestType = com.models.sec05.TransferReq.class,
      responseType = com.models.sec05.TransferResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.models.sec05.TransferReq,
      com.models.sec05.TransferResp> getTransferMethod() {
    io.grpc.MethodDescriptor<com.models.sec05.TransferReq, com.models.sec05.TransferResp> getTransferMethod;
    if ((getTransferMethod = BankServiceGrpc.getTransferMethod) == null) {
      synchronized (BankServiceGrpc.class) {
        if ((getTransferMethod = BankServiceGrpc.getTransferMethod) == null) {
          BankServiceGrpc.getTransferMethod = getTransferMethod =
              io.grpc.MethodDescriptor.<com.models.sec05.TransferReq, com.models.sec05.TransferResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Transfer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.TransferReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.models.sec05.TransferResp.getDefaultInstance()))
              .setSchemaDescriptor(new BankServiceMethodDescriptorSupplier("Transfer"))
              .build();
        }
      }
    }
    return getTransferMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BankServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceStub>() {
        @java.lang.Override
        public BankServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceStub(channel, callOptions);
        }
      };
    return BankServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BankServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceBlockingStub>() {
        @java.lang.Override
        public BankServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceBlockingStub(channel, callOptions);
        }
      };
    return BankServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BankServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BankServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BankServiceFutureStub>() {
        @java.lang.Override
        public BankServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BankServiceFutureStub(channel, callOptions);
        }
      };
    return BankServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Undary RPC
     * </pre>
     */
    default void getAccountBalance(com.models.sec05.BalanceCheckReq request,
        io.grpc.stub.StreamObserver<com.models.sec05.BalanceCheckResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountBalanceMethod(), responseObserver);
    }

    /**
     */
    default void getAllAccounts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.models.sec05.AllAccountsResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllAccountsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server stream
     * </pre>
     */
    default void withdraw(com.models.sec05.WithdrawReq request,
        io.grpc.stub.StreamObserver<com.models.sec05.Money> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWithdrawMethod(), responseObserver);
    }

    /**
     * <pre>
     * Client stream
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.models.sec05.DepositRequest> deposit(
        io.grpc.stub.StreamObserver<com.models.sec05.BalanceCheckResp> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getDepositMethod(), responseObserver);
    }

    /**
     * <pre>
     *Bi-directional stream
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.models.sec05.TransferReq> transfer(
        io.grpc.stub.StreamObserver<com.models.sec05.TransferResp> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getTransferMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BankService.
   */
  public static abstract class BankServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BankServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BankService.
   */
  public static final class BankServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BankServiceStub> {
    private BankServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Undary RPC
     * </pre>
     */
    public void getAccountBalance(com.models.sec05.BalanceCheckReq request,
        io.grpc.stub.StreamObserver<com.models.sec05.BalanceCheckResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllAccounts(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.models.sec05.AllAccountsResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllAccountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server stream
     * </pre>
     */
    public void withdraw(com.models.sec05.WithdrawReq request,
        io.grpc.stub.StreamObserver<com.models.sec05.Money> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getWithdrawMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Client stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.models.sec05.DepositRequest> deposit(
        io.grpc.stub.StreamObserver<com.models.sec05.BalanceCheckResp> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getDepositMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *Bi-directional stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.models.sec05.TransferReq> transfer(
        io.grpc.stub.StreamObserver<com.models.sec05.TransferResp> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getTransferMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BankService.
   */
  public static final class BankServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BankServiceBlockingStub> {
    private BankServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Undary RPC
     * </pre>
     */
    public com.models.sec05.BalanceCheckResp getAccountBalance(com.models.sec05.BalanceCheckReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountBalanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.models.sec05.AllAccountsResp getAllAccounts(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllAccountsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server stream
     * </pre>
     */
    public java.util.Iterator<com.models.sec05.Money> withdraw(
        com.models.sec05.WithdrawReq request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getWithdrawMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BankService.
   */
  public static final class BankServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BankServiceFutureStub> {
    private BankServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BankServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BankServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Undary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.models.sec05.BalanceCheckResp> getAccountBalance(
        com.models.sec05.BalanceCheckReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountBalanceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.models.sec05.AllAccountsResp> getAllAccounts(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllAccountsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT_BALANCE = 0;
  private static final int METHODID_GET_ALL_ACCOUNTS = 1;
  private static final int METHODID_WITHDRAW = 2;
  private static final int METHODID_DEPOSIT = 3;
  private static final int METHODID_TRANSFER = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNT_BALANCE:
          serviceImpl.getAccountBalance((com.models.sec05.BalanceCheckReq) request,
              (io.grpc.stub.StreamObserver<com.models.sec05.BalanceCheckResp>) responseObserver);
          break;
        case METHODID_GET_ALL_ACCOUNTS:
          serviceImpl.getAllAccounts((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.models.sec05.AllAccountsResp>) responseObserver);
          break;
        case METHODID_WITHDRAW:
          serviceImpl.withdraw((com.models.sec05.WithdrawReq) request,
              (io.grpc.stub.StreamObserver<com.models.sec05.Money>) responseObserver);
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
        case METHODID_DEPOSIT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.deposit(
              (io.grpc.stub.StreamObserver<com.models.sec05.BalanceCheckResp>) responseObserver);
        case METHODID_TRANSFER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.transfer(
              (io.grpc.stub.StreamObserver<com.models.sec05.TransferResp>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetAccountBalanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.models.sec05.BalanceCheckReq,
              com.models.sec05.BalanceCheckResp>(
                service, METHODID_GET_ACCOUNT_BALANCE)))
        .addMethod(
          getGetAllAccountsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.models.sec05.AllAccountsResp>(
                service, METHODID_GET_ALL_ACCOUNTS)))
        .addMethod(
          getWithdrawMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.models.sec05.WithdrawReq,
              com.models.sec05.Money>(
                service, METHODID_WITHDRAW)))
        .addMethod(
          getDepositMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.models.sec05.DepositRequest,
              com.models.sec05.BalanceCheckResp>(
                service, METHODID_DEPOSIT)))
        .addMethod(
          getTransferMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.models.sec05.TransferReq,
              com.models.sec05.TransferResp>(
                service, METHODID_TRANSFER)))
        .build();
  }

  private static abstract class BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BankServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.models.sec05.BankServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BankService");
    }
  }

  private static final class BankServiceFileDescriptorSupplier
      extends BankServiceBaseDescriptorSupplier {
    BankServiceFileDescriptorSupplier() {}
  }

  private static final class BankServiceMethodDescriptorSupplier
      extends BankServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BankServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BankServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BankServiceFileDescriptorSupplier())
              .addMethod(getGetAccountBalanceMethod())
              .addMethod(getGetAllAccountsMethod())
              .addMethod(getWithdrawMethod())
              .addMethod(getDepositMethod())
              .addMethod(getTransferMethod())
              .build();
        }
      }
    }
    return result;
  }
}
