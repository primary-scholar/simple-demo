package com.mimu.simple.comn.grpc;

import io.grpc.Server;

import java.io.IOException;


/**
 * author: mimu
 * date: 2019/1/9
 */

public class HelloWorldServer {

    private int port;
    private Server server;

    HelloWorldServer(int port) {
        this.port = port;
        server = ServerBuilder.forPort(this.port).addService(new GreeterImpl()).build();
    }

    public void start() throws IOException {
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("server shutdown...");
            HelloWorldServer.this.stop();
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
            System.out.println("server receive: " + request.getName());
            HelloReply reply = HelloReply.newBuilder().setMessage("hello: " + request.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

}
