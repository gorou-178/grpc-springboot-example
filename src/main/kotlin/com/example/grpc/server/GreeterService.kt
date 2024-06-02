package com.example.grpc.server

import com.example.grpc.server.greeter.Greeter
import com.example.grpc.server.greeter.GreeterServiceGrpc
import io.grpc.stub.StreamObserver

class GreeterService : GreeterServiceGrpc.GreeterServiceImplBase() {

    override fun sayHello(request: Greeter.HelloRequest, responseObserver: StreamObserver<Greeter.HelloReply>) {
        val reply = Greeter.HelloReply.newBuilder().setMessage("Hello, ${request.name}!").build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}
