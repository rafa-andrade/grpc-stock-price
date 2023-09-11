# grpc-stock-price

![Java](https://img.shields.io/badge/Java-17-blue) 
![Maven](https://img.shields.io/badge/Maven-3.9.3-green) 
![Protocol Buffers](https://img.shields.io/badge/protoc-3.17.2-yellow) 
![gRPC](https://img.shields.io/badge/io.GRPC-1.40.1-red)

This is a proof of concept (PoC) project in Java 17 and Maven that demonstrates the use of gRPC in a stock price query system. gRPC is known for its high-speed remote calls, making it ideal for systems that require high-performance queries.

## Features

The project consists of two main components: the gRPC server and the client.

### gRPC Server

The `GrpcServer` class initializes and starts the gRPC server.

### Service Implementation

The `StockPriceServiceImpl` class manages stock prices and responds to client requests.

### Client

The `StockPriceClient` class connects to the server to obtain stock prices.

## How to Build the Project

To build the project, follow these steps:


1. **Clone the Repository:**
```sh
   git clone https://github.com/seu-usuario/grpc-stock-price.git
```

2. **Navigate to the Project Directory:**
```sh
   cd grpc-stock-price
```

3. **Build the Project:**

   Use o Maven para construir o projeto:
```sh
   ./mvnw clean install
```

## Tests

Check the `StockPriceServiceIntegrationTest` class for testing the service integration.
