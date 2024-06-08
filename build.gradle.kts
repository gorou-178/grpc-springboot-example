import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.logging.configuration.ConsoleOutput
import org.gradle.api.logging.LogLevel

plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // grpc系のコードで必要
    implementation("io.grpc:grpc-stub:1.62.2")
    implementation("io.grpc:grpc-protobuf:1.62.2")
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")

    implementation("com.google.protobuf:protobuf-kotlin:3.25.3")
    implementation("io.grpc:grpc-netty-shaded:1.62.2") // grpc serverの起動で必要になった shadedはgrpc系との依存を排除したもの

    implementation("io.grpc:grpc-services:1.62.2") // grpc listでリフレクションの対応のために必要
    implementation("com.google.protobuf:protobuf-java:3.25.3")
    implementation("com.google.protobuf:protobuf-kotlin:3.25.3")
    implementation("build.buf:protovalidate:0.2.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

gradle.startParameter.apply {
    showStacktrace = org.gradle.api.logging.configuration.ShowStacktrace.ALWAYS
    consoleOutput = ConsoleOutput.Plain
    logLevel = LogLevel.INFO // または LogLevel.WARN
}

tasks.withType<Test> {
    useJUnitPlatform()
}
