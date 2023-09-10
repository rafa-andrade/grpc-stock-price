package com.rafaandrade.grpc.stockprice.server;

import com.rafaandrade.grpc.stockprice.PriceRequest;
import com.rafaandrade.grpc.stockprice.PriceResponse;
import com.rafaandrade.grpc.stockprice.StockPriceServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

public class StockPriceServiceImpl extends StockPriceServiceGrpc.StockPriceServiceImplBase {

    private static Map<String, Long> stockPrices = new HashMap<>();

    static {
        stockPrices.put("FB", 5285L);
        stockPrices.put("AAPL", 17818L);
        stockPrices.put("GOOGL", 13638L);
    }

    @Override
    public void getPrice(PriceRequest request, StreamObserver<PriceResponse> responseObserver) {
        System.out.println("Request received from client: " + request);

        PriceResponse response = PriceResponse.newBuilder()
            .setStockCode(request.getStockCode())
            .setStockPrice(stockPrices.getOrDefault(request.getStockCode(), 0L))
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
