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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: data.proto")
public final class DataServiceGrpc {

  private DataServiceGrpc() {}

  public static final String SERVICE_NAME = "DataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Data.StudentRequest,
      Data.StudentResponse> getGetStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudents",
      requestType = Data.StudentRequest.class,
      responseType = Data.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Data.StudentRequest,
      Data.StudentResponse> getGetStudentsMethod() {
    io.grpc.MethodDescriptor<Data.StudentRequest, Data.StudentResponse> getGetStudentsMethod;
    if ((getGetStudentsMethod = DataServiceGrpc.getGetStudentsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetStudentsMethod = DataServiceGrpc.getGetStudentsMethod) == null) {
          DataServiceGrpc.getGetStudentsMethod = getGetStudentsMethod =
              io.grpc.MethodDescriptor.<Data.StudentRequest, Data.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.StudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("getStudents"))
              .build();
        }
      }
    }
    return getGetStudentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Data.Student,
      Data.IsSuccess> getAddStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addStudent",
      requestType = Data.Student.class,
      responseType = Data.IsSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Data.Student,
      Data.IsSuccess> getAddStudentMethod() {
    io.grpc.MethodDescriptor<Data.Student, Data.IsSuccess> getAddStudentMethod;
    if ((getAddStudentMethod = DataServiceGrpc.getAddStudentMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getAddStudentMethod = DataServiceGrpc.getAddStudentMethod) == null) {
          DataServiceGrpc.getAddStudentMethod = getAddStudentMethod =
              io.grpc.MethodDescriptor.<Data.Student, Data.IsSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.Student.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.IsSuccess.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("addStudent"))
              .build();
        }
      }
    }
    return getAddStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Data.deleteNum,
      Data.IsSuccess> getDeleteStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteStudent",
      requestType = Data.deleteNum.class,
      responseType = Data.IsSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Data.deleteNum,
      Data.IsSuccess> getDeleteStudentMethod() {
    io.grpc.MethodDescriptor<Data.deleteNum, Data.IsSuccess> getDeleteStudentMethod;
    if ((getDeleteStudentMethod = DataServiceGrpc.getDeleteStudentMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getDeleteStudentMethod = DataServiceGrpc.getDeleteStudentMethod) == null) {
          DataServiceGrpc.getDeleteStudentMethod = getDeleteStudentMethod =
              io.grpc.MethodDescriptor.<Data.deleteNum, Data.IsSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.deleteNum.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.IsSuccess.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("deleteStudent"))
              .build();
        }
      }
    }
    return getDeleteStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Data.CourseRequest,
      Data.CourseResponse> getGetCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCourses",
      requestType = Data.CourseRequest.class,
      responseType = Data.CourseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Data.CourseRequest,
      Data.CourseResponse> getGetCoursesMethod() {
    io.grpc.MethodDescriptor<Data.CourseRequest, Data.CourseResponse> getGetCoursesMethod;
    if ((getGetCoursesMethod = DataServiceGrpc.getGetCoursesMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetCoursesMethod = DataServiceGrpc.getGetCoursesMethod) == null) {
          DataServiceGrpc.getGetCoursesMethod = getGetCoursesMethod =
              io.grpc.MethodDescriptor.<Data.CourseRequest, Data.CourseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.CourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.CourseResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("getCourses"))
              .build();
        }
      }
    }
    return getGetCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Data.Course,
      Data.IsSuccess> getAddCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCourse",
      requestType = Data.Course.class,
      responseType = Data.IsSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Data.Course,
      Data.IsSuccess> getAddCourseMethod() {
    io.grpc.MethodDescriptor<Data.Course, Data.IsSuccess> getAddCourseMethod;
    if ((getAddCourseMethod = DataServiceGrpc.getAddCourseMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getAddCourseMethod = DataServiceGrpc.getAddCourseMethod) == null) {
          DataServiceGrpc.getAddCourseMethod = getAddCourseMethod =
              io.grpc.MethodDescriptor.<Data.Course, Data.IsSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.Course.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.IsSuccess.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("addCourse"))
              .build();
        }
      }
    }
    return getAddCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Data.deleteNum,
      Data.IsSuccess> getDeleteCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCourse",
      requestType = Data.deleteNum.class,
      responseType = Data.IsSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Data.deleteNum,
      Data.IsSuccess> getDeleteCourseMethod() {
    io.grpc.MethodDescriptor<Data.deleteNum, Data.IsSuccess> getDeleteCourseMethod;
    if ((getDeleteCourseMethod = DataServiceGrpc.getDeleteCourseMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getDeleteCourseMethod = DataServiceGrpc.getDeleteCourseMethod) == null) {
          DataServiceGrpc.getDeleteCourseMethod = getDeleteCourseMethod =
              io.grpc.MethodDescriptor.<Data.deleteNum, Data.IsSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.deleteNum.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.IsSuccess.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("deleteCourse"))
              .build();
        }
      }
    }
    return getDeleteCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Data.EnrollmentRequest,
      Data.EnrollmentResponse> getGetEnrollmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEnrollment",
      requestType = Data.EnrollmentRequest.class,
      responseType = Data.EnrollmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Data.EnrollmentRequest,
      Data.EnrollmentResponse> getGetEnrollmentMethod() {
    io.grpc.MethodDescriptor<Data.EnrollmentRequest, Data.EnrollmentResponse> getGetEnrollmentMethod;
    if ((getGetEnrollmentMethod = DataServiceGrpc.getGetEnrollmentMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getGetEnrollmentMethod = DataServiceGrpc.getGetEnrollmentMethod) == null) {
          DataServiceGrpc.getGetEnrollmentMethod = getGetEnrollmentMethod =
              io.grpc.MethodDescriptor.<Data.EnrollmentRequest, Data.EnrollmentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getEnrollment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.EnrollmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.EnrollmentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("getEnrollment"))
              .build();
        }
      }
    }
    return getGetEnrollmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Data.Enrollment,
      Data.IsEnroll> getEnrollMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "enroll",
      requestType = Data.Enrollment.class,
      responseType = Data.IsEnroll.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Data.Enrollment,
      Data.IsEnroll> getEnrollMethod() {
    io.grpc.MethodDescriptor<Data.Enrollment, Data.IsEnroll> getEnrollMethod;
    if ((getEnrollMethod = DataServiceGrpc.getEnrollMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getEnrollMethod = DataServiceGrpc.getEnrollMethod) == null) {
          DataServiceGrpc.getEnrollMethod = getEnrollMethod =
              io.grpc.MethodDescriptor.<Data.Enrollment, Data.IsEnroll>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "enroll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.Enrollment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Data.IsEnroll.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("enroll"))
              .build();
        }
      }
    }
    return getEnrollMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceStub>() {
        @java.lang.Override
        public DataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceStub(channel, callOptions);
        }
      };
    return DataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub>() {
        @java.lang.Override
        public DataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceBlockingStub(channel, callOptions);
        }
      };
    return DataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub>() {
        @java.lang.Override
        public DataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceFutureStub(channel, callOptions);
        }
      };
    return DataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DataServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getStudents(Data.StudentRequest request,
        io.grpc.stub.StreamObserver<Data.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsMethod(), responseObserver);
    }

    /**
     */
    public void addStudent(Data.Student request,
        io.grpc.stub.StreamObserver<Data.IsSuccess> responseObserver) {
      asyncUnimplementedUnaryCall(getAddStudentMethod(), responseObserver);
    }

    /**
     */
    public void deleteStudent(Data.deleteNum request,
        io.grpc.stub.StreamObserver<Data.IsSuccess> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteStudentMethod(), responseObserver);
    }

    /**
     */
    public void getCourses(Data.CourseRequest request,
        io.grpc.stub.StreamObserver<Data.CourseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCoursesMethod(), responseObserver);
    }

    /**
     */
    public void addCourse(Data.Course request,
        io.grpc.stub.StreamObserver<Data.IsSuccess> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCourseMethod(), responseObserver);
    }

    /**
     */
    public void deleteCourse(Data.deleteNum request,
        io.grpc.stub.StreamObserver<Data.IsSuccess> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCourseMethod(), responseObserver);
    }

    /**
     */
    public void getEnrollment(Data.EnrollmentRequest request,
        io.grpc.stub.StreamObserver<Data.EnrollmentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEnrollmentMethod(), responseObserver);
    }

    /**
     */
    public void enroll(Data.Enrollment request,
        io.grpc.stub.StreamObserver<Data.IsEnroll> responseObserver) {
      asyncUnimplementedUnaryCall(getEnrollMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetStudentsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.StudentRequest,
                Data.StudentResponse>(
                  this, METHODID_GET_STUDENTS)))
          .addMethod(
            getAddStudentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.Student,
                Data.IsSuccess>(
                  this, METHODID_ADD_STUDENT)))
          .addMethod(
            getDeleteStudentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.deleteNum,
                Data.IsSuccess>(
                  this, METHODID_DELETE_STUDENT)))
          .addMethod(
            getGetCoursesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.CourseRequest,
                Data.CourseResponse>(
                  this, METHODID_GET_COURSES)))
          .addMethod(
            getAddCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.Course,
                Data.IsSuccess>(
                  this, METHODID_ADD_COURSE)))
          .addMethod(
            getDeleteCourseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.deleteNum,
                Data.IsSuccess>(
                  this, METHODID_DELETE_COURSE)))
          .addMethod(
            getGetEnrollmentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.EnrollmentRequest,
                Data.EnrollmentResponse>(
                  this, METHODID_GET_ENROLLMENT)))
          .addMethod(
            getEnrollMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Data.Enrollment,
                Data.IsEnroll>(
                  this, METHODID_ENROLL)))
          .build();
    }
  }

  /**
   */
  public static final class DataServiceStub extends io.grpc.stub.AbstractAsyncStub<DataServiceStub> {
    private DataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceStub(channel, callOptions);
    }

    /**
     */
    public void getStudents(Data.StudentRequest request,
        io.grpc.stub.StreamObserver<Data.StudentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStudentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addStudent(Data.Student request,
        io.grpc.stub.StreamObserver<Data.IsSuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteStudent(Data.deleteNum request,
        io.grpc.stub.StreamObserver<Data.IsSuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourses(Data.CourseRequest request,
        io.grpc.stub.StreamObserver<Data.CourseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCourse(Data.Course request,
        io.grpc.stub.StreamObserver<Data.IsSuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCourse(Data.deleteNum request,
        io.grpc.stub.StreamObserver<Data.IsSuccess> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEnrollment(Data.EnrollmentRequest request,
        io.grpc.stub.StreamObserver<Data.EnrollmentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEnrollmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void enroll(Data.Enrollment request,
        io.grpc.stub.StreamObserver<Data.IsEnroll> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnrollMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataServiceBlockingStub> {
    private DataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Data.StudentResponse getStudents(Data.StudentRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStudentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Data.IsSuccess addStudent(Data.Student request) {
      return blockingUnaryCall(
          getChannel(), getAddStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public Data.IsSuccess deleteStudent(Data.deleteNum request) {
      return blockingUnaryCall(
          getChannel(), getDeleteStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public Data.CourseResponse getCourses(Data.CourseRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public Data.IsSuccess addCourse(Data.Course request) {
      return blockingUnaryCall(
          getChannel(), getAddCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public Data.IsSuccess deleteCourse(Data.deleteNum request) {
      return blockingUnaryCall(
          getChannel(), getDeleteCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public Data.EnrollmentResponse getEnrollment(Data.EnrollmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEnrollmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public Data.IsEnroll enroll(Data.Enrollment request) {
      return blockingUnaryCall(
          getChannel(), getEnrollMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataServiceFutureStub> {
    private DataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.StudentResponse> getStudents(
        Data.StudentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStudentsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.IsSuccess> addStudent(
        Data.Student request) {
      return futureUnaryCall(
          getChannel().newCall(getAddStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.IsSuccess> deleteStudent(
        Data.deleteNum request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.CourseResponse> getCourses(
        Data.CourseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCoursesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.IsSuccess> addCourse(
        Data.Course request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.IsSuccess> deleteCourse(
        Data.deleteNum request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.EnrollmentResponse> getEnrollment(
        Data.EnrollmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEnrollmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Data.IsEnroll> enroll(
        Data.Enrollment request) {
      return futureUnaryCall(
          getChannel().newCall(getEnrollMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STUDENTS = 0;
  private static final int METHODID_ADD_STUDENT = 1;
  private static final int METHODID_DELETE_STUDENT = 2;
  private static final int METHODID_GET_COURSES = 3;
  private static final int METHODID_ADD_COURSE = 4;
  private static final int METHODID_DELETE_COURSE = 5;
  private static final int METHODID_GET_ENROLLMENT = 6;
  private static final int METHODID_ENROLL = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENTS:
          serviceImpl.getStudents((Data.StudentRequest) request,
              (io.grpc.stub.StreamObserver<Data.StudentResponse>) responseObserver);
          break;
        case METHODID_ADD_STUDENT:
          serviceImpl.addStudent((Data.Student) request,
              (io.grpc.stub.StreamObserver<Data.IsSuccess>) responseObserver);
          break;
        case METHODID_DELETE_STUDENT:
          serviceImpl.deleteStudent((Data.deleteNum) request,
              (io.grpc.stub.StreamObserver<Data.IsSuccess>) responseObserver);
          break;
        case METHODID_GET_COURSES:
          serviceImpl.getCourses((Data.CourseRequest) request,
              (io.grpc.stub.StreamObserver<Data.CourseResponse>) responseObserver);
          break;
        case METHODID_ADD_COURSE:
          serviceImpl.addCourse((Data.Course) request,
              (io.grpc.stub.StreamObserver<Data.IsSuccess>) responseObserver);
          break;
        case METHODID_DELETE_COURSE:
          serviceImpl.deleteCourse((Data.deleteNum) request,
              (io.grpc.stub.StreamObserver<Data.IsSuccess>) responseObserver);
          break;
        case METHODID_GET_ENROLLMENT:
          serviceImpl.getEnrollment((Data.EnrollmentRequest) request,
              (io.grpc.stub.StreamObserver<Data.EnrollmentResponse>) responseObserver);
          break;
        case METHODID_ENROLL:
          serviceImpl.enroll((Data.Enrollment) request,
              (io.grpc.stub.StreamObserver<Data.IsEnroll>) responseObserver);
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

  private static abstract class DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Data.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataService");
    }
  }

  private static final class DataServiceFileDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier {
    DataServiceFileDescriptorSupplier() {}
  }

  private static final class DataServiceMethodDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataServiceFileDescriptorSupplier())
              .addMethod(getGetStudentsMethod())
              .addMethod(getAddStudentMethod())
              .addMethod(getDeleteStudentMethod())
              .addMethod(getGetCoursesMethod())
              .addMethod(getAddCourseMethod())
              .addMethod(getDeleteCourseMethod())
              .addMethod(getGetEnrollmentMethod())
              .addMethod(getEnrollMethod())
              .build();
        }
      }
    }
    return result;
  }
}
