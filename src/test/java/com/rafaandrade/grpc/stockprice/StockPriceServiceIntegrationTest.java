package com.rafaandrade.grpc.stockprice;

import com.rafaandrade.grpc.stockprice.client.StockPriceClient;
import com.rafaandrade.grpc.stockprice.server.GrpcServer;
import io.grpc.ManagedChannel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.rafaandrade.grpc.stockprice.StockPriceServiceGrpc.newBlockingStub;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockPriceServiceIntegrationTest {

  private GrpcServer grpcServer = new GrpcServer();

  private StockPriceClient stockPriceClient;

  @BeforeEach
  public void init() {
    grpcServer.start();
  }

  @Test
  public void testGetPrice() {
    ManagedChannel channel = StockPriceClient.getChannel();

    stockPriceClient = new StockPriceClient(newBlockingStub(channel));

    assertTrue(stockPriceClient.getPrice("FB") > 0L);
    assertTrue(stockPriceClient.getPrice("AAPL") > 0L);
    assertTrue(stockPriceClient.getPrice("GOOGL") > 0L);

    channel.shutdown();
  }

}
