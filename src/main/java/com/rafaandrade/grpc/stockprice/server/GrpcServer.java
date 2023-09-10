package com.rafaandrade.grpc.stockprice.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer extends Thread {

    @Override
    public void run() {
        Server server = ServerBuilder.forPort(8080)
            .addService(new StockPriceServiceImpl())
            .build();

        try {
            System.out.println("Starting GRCP server...");
            server.start();
            System.out.println("Server GRCP started!");
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new GrpcServer().start();
    }
}