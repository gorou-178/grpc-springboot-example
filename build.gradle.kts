import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
//    id("com.google.protobuf") version "0.9.4"
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

    // implementation("org.springframework.boot:spring-boot-starter")
    // implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")
    // implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.10")
    // implementation("io.grpc:grpc-netty-shaded:1.42.2")
    // implementation("io.grpc:grpc-protobuf:1.42.2")
    // implementation("io.grpc:grpc-stub:1.42.2")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // grpc系のコードで必要
    api("io.grpc:grpc-stub:1.62.2")
    implementation("io.grpc:grpc-protobuf:1.62.2")
    api("io.grpc:grpc-kotlin-stub:1.4.1")

    //implementation("com.google.protobuf:protobuf-kotlin:4.27.0") // code generateで必要になった
    implementation("com.google.protobuf:protobuf-kotlin:3.25.3")
    implementation("io.grpc:grpc-netty-shaded:1.62.2") // grpc serverの起動で必要になった shadedはgrpc系との依存を排除したもの


    implementation("io.grpc:grpc-services:1.62.2") // grpc listでリフレクションの対応のために必要
    //implementation("com.google.protobuf:protobuf-java:4.27.0") // grpc-servicesの依存ライブラリ。protobuf-kotlinとversionあわせる必要がある
    implementation("com.google.protobuf:protobuf-java:3.25.3")

    // implementation("net.devh:grpc-spring-boot-starter")
    // implementation("buf.validate:validate-java:1.0.0") // Add protovalidate library
    // implementation("build.buf:protovalidate:0.2.1")
    // testImplementation("org.springframework.boot:spring-boot-starter-test")
    // testImplementation("io.grpc:grpc-testing:1.42.1")
}

//sourceSets {
//    main {
//        kotlin {
//            srcDirs("build/generated/source/proto/main/kotlin")
//        }
//    }
//}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

//protobuf {
//    generateProtoTasks {
//        all().forEach { task ->
//            task.enabled = false // Buf CLIでコード生成するので、無効化
//        }
//    }
//}

tasks.withType<Test> {
    useJUnitPlatform()
}
