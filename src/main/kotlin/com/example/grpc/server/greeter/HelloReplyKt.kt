// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: proto/com/example/grpc/server/greeter/greeter.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package com.example.grpc.server.greeter;

@kotlin.jvm.JvmName("-initializehelloReply")
public inline fun helloReply(block: com.example.grpc.server.greeter.HelloReplyKt.Dsl.() -> kotlin.Unit): com.example.grpc.server.greeter.Greeter.HelloReply =
  com.example.grpc.server.greeter.HelloReplyKt.Dsl._create(com.example.grpc.server.greeter.Greeter.HelloReply.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `HelloReply`
 */
public object HelloReplyKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: com.example.grpc.server.greeter.Greeter.HelloReply.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.example.grpc.server.greeter.Greeter.HelloReply.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.example.grpc.server.greeter.Greeter.HelloReply = _builder.build()

    /**
     * `string message = 1 [json_name = "message", (.buf.validate.field) = { ... }`
     */
    public var message: kotlin.String
      @JvmName("getMessage")
      get() = _builder.getMessage()
      @JvmName("setMessage")
      set(value) {
        _builder.setMessage(value)
      }
    /**
     * `string message = 1 [json_name = "message", (.buf.validate.field) = { ... }`
     */
    public fun clearMessage() {
      _builder.clearMessage()
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun com.example.grpc.server.greeter.Greeter.HelloReply.copy(block: `com.example.grpc.server.greeter`.HelloReplyKt.Dsl.() -> kotlin.Unit): com.example.grpc.server.greeter.Greeter.HelloReply =
  `com.example.grpc.server.greeter`.HelloReplyKt.Dsl._create(this.toBuilder()).apply { block() }._build()

