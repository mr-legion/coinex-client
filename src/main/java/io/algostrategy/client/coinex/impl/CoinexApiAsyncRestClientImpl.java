package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiAsyncRestClient;
import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import io.algostrategy.client.coinex.domain.market.MarketInfo;
import io.algostrategy.client.coinex.domain.market.MarketTickerResponse;
import io.algostrategy.client.coinex.domain.market.OrderBook;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of Coinex's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class CoinexApiAsyncRestClientImpl implements CoinexApiAsyncRestClient {

    private final CoinexApiService coinexApiService;

    public CoinexApiAsyncRestClientImpl(CoinexApiService coinexApiService) {
        this.coinexApiService = coinexApiService;
    }

    // General endpoints

    @Override
    public CompletableFuture<Response<Map<String, Asset>>> getAssets() {
        CompletableFuture<Response<Map<String, Asset>>> future = new CompletableFuture<>();
        coinexApiService.getAssets().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    // Market endpoints

    @Override
    public CompletableFuture<Response<Map<String, MarketInfo>>> getMarketInfo() {
        CompletableFuture<Response<Map<String, MarketInfo>>> future = new CompletableFuture<>();
        coinexApiService.getMarketInfo().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<MarketTickerResponse>> getMarketTickers() {
        CompletableFuture<Response<MarketTickerResponse>> future = new CompletableFuture<>();
        coinexApiService.getMarketTickers().enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }

    @Override
    public CompletableFuture<Response<OrderBook>> getOrderBook(String market, Integer limit, String aggLevel) {
        CompletableFuture<Response<OrderBook>> future = new CompletableFuture<>();
        coinexApiService.getOrderBook(market, limit, aggLevel).enqueue(new RetrofitCallbackAdapter<>(future));
        return future;
    }
}
