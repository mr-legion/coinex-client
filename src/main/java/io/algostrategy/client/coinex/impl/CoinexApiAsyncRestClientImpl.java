package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiAsyncRestClient;
import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;

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
}
