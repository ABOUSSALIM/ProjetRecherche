package com.example.soap.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: hotel.proto")
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final String SERVICE_NAME = "ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.soap.stubs.CreateReservationRequest,
      com.example.soap.stubs.ReservationResponse> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = com.example.soap.stubs.CreateReservationRequest.class,
      responseType = com.example.soap.stubs.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.soap.stubs.CreateReservationRequest,
      com.example.soap.stubs.ReservationResponse> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<com.example.soap.stubs.CreateReservationRequest, com.example.soap.stubs.ReservationResponse> getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
          ReservationServiceGrpc.getCreateReservationMethod = getCreateReservationMethod = 
              io.grpc.MethodDescriptor.<com.example.soap.stubs.CreateReservationRequest, com.example.soap.stubs.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "CreateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.CreateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("CreateReservation"))
                  .build();
          }
        }
     }
     return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.soap.stubs.GetReservationRequest,
      com.example.soap.stubs.ReservationResponse> getGetReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservation",
      requestType = com.example.soap.stubs.GetReservationRequest.class,
      responseType = com.example.soap.stubs.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.soap.stubs.GetReservationRequest,
      com.example.soap.stubs.ReservationResponse> getGetReservationMethod() {
    io.grpc.MethodDescriptor<com.example.soap.stubs.GetReservationRequest, com.example.soap.stubs.ReservationResponse> getGetReservationMethod;
    if ((getGetReservationMethod = ReservationServiceGrpc.getGetReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationMethod = ReservationServiceGrpc.getGetReservationMethod) == null) {
          ReservationServiceGrpc.getGetReservationMethod = getGetReservationMethod = 
              io.grpc.MethodDescriptor.<com.example.soap.stubs.GetReservationRequest, com.example.soap.stubs.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.GetReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservation"))
                  .build();
          }
        }
     }
     return getGetReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.soap.stubs.GetAllReservationsRequest,
      com.example.soap.stubs.ReservationList> getGetAllReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllReservations",
      requestType = com.example.soap.stubs.GetAllReservationsRequest.class,
      responseType = com.example.soap.stubs.ReservationList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.soap.stubs.GetAllReservationsRequest,
      com.example.soap.stubs.ReservationList> getGetAllReservationsMethod() {
    io.grpc.MethodDescriptor<com.example.soap.stubs.GetAllReservationsRequest, com.example.soap.stubs.ReservationList> getGetAllReservationsMethod;
    if ((getGetAllReservationsMethod = ReservationServiceGrpc.getGetAllReservationsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetAllReservationsMethod = ReservationServiceGrpc.getGetAllReservationsMethod) == null) {
          ReservationServiceGrpc.getGetAllReservationsMethod = getGetAllReservationsMethod = 
              io.grpc.MethodDescriptor.<com.example.soap.stubs.GetAllReservationsRequest, com.example.soap.stubs.ReservationList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetAllReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.GetAllReservationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.ReservationList.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetAllReservations"))
                  .build();
          }
        }
     }
     return getGetAllReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.soap.stubs.UpdateReservationRequest,
      com.example.soap.stubs.ReservationResponse> getUpdateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReservation",
      requestType = com.example.soap.stubs.UpdateReservationRequest.class,
      responseType = com.example.soap.stubs.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.soap.stubs.UpdateReservationRequest,
      com.example.soap.stubs.ReservationResponse> getUpdateReservationMethod() {
    io.grpc.MethodDescriptor<com.example.soap.stubs.UpdateReservationRequest, com.example.soap.stubs.ReservationResponse> getUpdateReservationMethod;
    if ((getUpdateReservationMethod = ReservationServiceGrpc.getUpdateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getUpdateReservationMethod = ReservationServiceGrpc.getUpdateReservationMethod) == null) {
          ReservationServiceGrpc.getUpdateReservationMethod = getUpdateReservationMethod = 
              io.grpc.MethodDescriptor.<com.example.soap.stubs.UpdateReservationRequest, com.example.soap.stubs.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "UpdateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.UpdateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("UpdateReservation"))
                  .build();
          }
        }
     }
     return getUpdateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.soap.stubs.DeleteReservationRequest,
      com.example.soap.stubs.DeleteReservationResponse> getDeleteReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReservation",
      requestType = com.example.soap.stubs.DeleteReservationRequest.class,
      responseType = com.example.soap.stubs.DeleteReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.soap.stubs.DeleteReservationRequest,
      com.example.soap.stubs.DeleteReservationResponse> getDeleteReservationMethod() {
    io.grpc.MethodDescriptor<com.example.soap.stubs.DeleteReservationRequest, com.example.soap.stubs.DeleteReservationResponse> getDeleteReservationMethod;
    if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
          ReservationServiceGrpc.getDeleteReservationMethod = getDeleteReservationMethod = 
              io.grpc.MethodDescriptor.<com.example.soap.stubs.DeleteReservationRequest, com.example.soap.stubs.DeleteReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "DeleteReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.DeleteReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.soap.stubs.DeleteReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("DeleteReservation"))
                  .build();
          }
        }
     }
     return getDeleteReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    return new ReservationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReservationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReservationServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static abstract class ReservationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createReservation(com.example.soap.stubs.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     */
    public void getReservation(com.example.soap.stubs.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationMethod(), responseObserver);
    }

    /**
     */
    public void getAllReservations(com.example.soap.stubs.GetAllReservationsRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllReservationsMethod(), responseObserver);
    }

    /**
     */
    public void updateReservation(com.example.soap.stubs.UpdateReservationRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateReservationMethod(), responseObserver);
    }

    /**
     */
    public void deleteReservation(com.example.soap.stubs.DeleteReservationRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.DeleteReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteReservationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.soap.stubs.CreateReservationRequest,
                com.example.soap.stubs.ReservationResponse>(
                  this, METHODID_CREATE_RESERVATION)))
          .addMethod(
            getGetReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.soap.stubs.GetReservationRequest,
                com.example.soap.stubs.ReservationResponse>(
                  this, METHODID_GET_RESERVATION)))
          .addMethod(
            getGetAllReservationsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.soap.stubs.GetAllReservationsRequest,
                com.example.soap.stubs.ReservationList>(
                  this, METHODID_GET_ALL_RESERVATIONS)))
          .addMethod(
            getUpdateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.soap.stubs.UpdateReservationRequest,
                com.example.soap.stubs.ReservationResponse>(
                  this, METHODID_UPDATE_RESERVATION)))
          .addMethod(
            getDeleteReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.soap.stubs.DeleteReservationRequest,
                com.example.soap.stubs.DeleteReservationResponse>(
                  this, METHODID_DELETE_RESERVATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class ReservationServiceStub extends io.grpc.stub.AbstractStub<ReservationServiceStub> {
    private ReservationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     */
    public void createReservation(com.example.soap.stubs.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservation(com.example.soap.stubs.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllReservations(com.example.soap.stubs.GetAllReservationsRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllReservationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateReservation(com.example.soap.stubs.UpdateReservationRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteReservation(com.example.soap.stubs.DeleteReservationRequest request,
        io.grpc.stub.StreamObserver<com.example.soap.stubs.DeleteReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class ReservationServiceBlockingStub extends io.grpc.stub.AbstractStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.soap.stubs.ReservationResponse createReservation(com.example.soap.stubs.CreateReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.soap.stubs.ReservationResponse getReservation(com.example.soap.stubs.GetReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.soap.stubs.ReservationList getAllReservations(com.example.soap.stubs.GetAllReservationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllReservationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.soap.stubs.ReservationResponse updateReservation(com.example.soap.stubs.UpdateReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.soap.stubs.DeleteReservationResponse deleteReservation(com.example.soap.stubs.DeleteReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service definition
   * </pre>
   */
  public static final class ReservationServiceFutureStub extends io.grpc.stub.AbstractStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.soap.stubs.ReservationResponse> createReservation(
        com.example.soap.stubs.CreateReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.soap.stubs.ReservationResponse> getReservation(
        com.example.soap.stubs.GetReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.soap.stubs.ReservationList> getAllReservations(
        com.example.soap.stubs.GetAllReservationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllReservationsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.soap.stubs.ReservationResponse> updateReservation(
        com.example.soap.stubs.UpdateReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.soap.stubs.DeleteReservationResponse> deleteReservation(
        com.example.soap.stubs.DeleteReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RESERVATION = 0;
  private static final int METHODID_GET_RESERVATION = 1;
  private static final int METHODID_GET_ALL_RESERVATIONS = 2;
  private static final int METHODID_UPDATE_RESERVATION = 3;
  private static final int METHODID_DELETE_RESERVATION = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((com.example.soap.stubs.CreateReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION:
          serviceImpl.getReservation((com.example.soap.stubs.GetReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_RESERVATIONS:
          serviceImpl.getAllReservations((com.example.soap.stubs.GetAllReservationsRequest) request,
              (io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationList>) responseObserver);
          break;
        case METHODID_UPDATE_RESERVATION:
          serviceImpl.updateReservation((com.example.soap.stubs.UpdateReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.example.soap.stubs.ReservationResponse>) responseObserver);
          break;
        case METHODID_DELETE_RESERVATION:
          serviceImpl.deleteReservation((com.example.soap.stubs.DeleteReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.example.soap.stubs.DeleteReservationResponse>) responseObserver);
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

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.soap.stubs.Hotel.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getCreateReservationMethod())
              .addMethod(getGetReservationMethod())
              .addMethod(getGetAllReservationsMethod())
              .addMethod(getUpdateReservationMethod())
              .addMethod(getDeleteReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
