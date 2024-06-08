# gRPC-SpringBoot-Example

このリポジトリは、Kotlinを使用してSpring BootとgRPCサーバーを構築するサンプルプロジェクトです。Protobufを使用して、Buf CLIでコード生成を行い、runnを使ってシナリオテストを実施します。また、BSRを利用してprotovalidateによるバリデーションも行います。

## 機能

- Kotlinで書かれたSpring Bootアプリケーション
- gRPCサーバーの実装
- Protobufによるプロトコル定義とコード生成
- Buf CLIを使用したコード生成
- runnによるシナリオテストの実行
- BSRを利用したprotovalidateによるバリデーション

## 必要なツール

- [Kotlin](https://kotlinlang.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [gRPC](https://grpc.io/)
- [Protobuf](https://developers.google.com/protocol-buffers)
- [Buf CLI](https://buf.build/)
- [runn](https://github.com/k1LoW/runn)
- [protovalidate](https://github.com/bufbuild/protovalidate)

## セットアップ

### 1. リポジトリのクローン

```bash
git clone https://github.com/yourusername/gRPC-SpringBoot-Example.git
cd gRPC-SpringBoot-Example
```

### 2. ビルド

```bash
./gradlew build
```

### 3. gRPCコード生成
`buf.gen.yaml` の設定でコード生成する。

```bash
buf generate
```

### 4. gRPC Serverの起動

```bash
./gradlew bootRun
```

## シナリオテストの実施
gRPC Serverを起動し、runnコマンドをインストール後に以下を実施。
localhostでgRPC Serverを立ち上げているため、`--grpc-no-tls` オプションを付けて実施すること。

```bash
runn run --grpc-no-tls greeterService-runn.yml
```
