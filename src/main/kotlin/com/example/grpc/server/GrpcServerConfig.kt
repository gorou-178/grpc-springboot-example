package com.example.grpc.server

import io.grpc.ServerBuilder
import io.grpc.protobuf.services.ProtoReflectionService
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class GrpcServerConfig(private val environment: Environment) {

    @Bean
    fun greeterService(): GreeterService {
        return GreeterService()
    }

    @Bean
    fun grpcServer(greeterService: GreeterService): CommandLineRunner {
        return CommandLineRunner {
            if (environment.getProperty("grpc.server.enabled", Boolean::class.java, true)) {
                val server = ServerBuilder.forPort(9090)
                    .addService(greeterService)
                    .addService(ProtoReflectionService.newInstance())
                    .build()
                    .start()
                println("gRPC server started on port 9090")

                Runtime.getRuntime().addShutdownHook(Thread {
                    server.shutdown()
                    println("gRPC server stopped")
                })

                server.awaitTermination()
            }
        }
    }
}
