package com.rafaandrade.grpc.stockprice.client;

import com.rafaandrade.grpc.stockprice.PriceRequest;
import com.rafaandrade.grpc.stockprice.StockPriceServiceGrpc.StockPriceServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static com.rafaandrade.grpc.stockprice.StockPriceServiceGrpc.newBlockingStub;

public class StockPriceClient {

    private final StockPriceServiceBlockingStub stockPriceService;

    public StockPriceClient(StockPriceServiceBlockingStub stockPriceService) {
        this.stockPriceService = stockPriceService;
    }
    public Long getPrice(String stockCode) {
        return stockPriceService.getPrice(PriceRequest.newBuilder()
            .setStockCode(stockCode)
            .build()
        ).getStockPrice();
    }

    public static ManagedChannel getChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();
    }

    public static void main(String[] args) {
        ManagedChannel channel = getChannel();

        StockPriceClient stockPriceClient = new StockPriceClient(newBlockingStub(channel));
        System.out.println("FB price is: " + stockPriceClient.getPrice("FB"));
        System.out.println("AAPL price is: " + stockPriceClient.getPrice("AAPL"));
        System.out.println("GOOGL price is: " + stockPriceClient.getPrice("GOOGL"));

        channel.shutdown();
    }
}
