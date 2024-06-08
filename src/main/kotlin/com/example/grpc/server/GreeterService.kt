package com.example.grpc.server

import build.buf.protovalidate.Validator
import build.buf.validate.Violation
import com.example.grpc.server.greeter.Greeter
import com.example.grpc.server.greeter.GreeterServiceGrpc
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.grpc.stub.StreamObserver

class GreeterService : GreeterServiceGrpc.GreeterServiceImplBase() {

    override fun sayHello(request: Greeter.HelloRequest, responseObserver: StreamObserver<Greeter.HelloReply>) {

        val requestResult = Validator().validate(request)
        try {
            if (! requestResult.isSuccess) {
                responseObserver.onError(
                    StatusRuntimeException(
                        createInvalidArgumentStatus(createMessage(requestResult.violations))
                    )
                )
            }
        } catch (e: Exception) {
            responseObserver.onError(
                StatusRuntimeException(
                    createInvalidArgumentStatus(createMessage(requestResult.violations))
                )
            )
        }

        val reply = Greeter.HelloReply.newBuilder().setMessage("Hello, ${request.name}!").build()
        try {
            val result = Validator().validate(reply)
            if (result.isSuccess) {
                responseObserver.onNext(reply)
                responseObserver.onCompleted()
            } else {
                responseObserver.onError(
                    StatusRuntimeException(
                        createInvalidArgumentStatus(createMessage(result.violations))
                    )
                )
            }
        } catch (e: Exception) {
            responseObserver.onError(
                StatusRuntimeException(
                    createInvalidArgumentStatus(e.message ?: "Unknown error")
                )
            )
        }
    }

    private fun createMessage(violations: List<Violation>): String {
        val sb = StringBuilder()
        sb.append("Validation failed:\n")
        violations.forEach {
            sb.append("property: ").append(it.fieldPath).append("\n")
                .append("  message: ").append(it.message).append("\n")
        }
        return sb.toString()
    }

    private fun createInvalidArgumentStatus(description: String): Status {
        return Status.INVALID_ARGUMENT.withDescription(description)
    }
}
