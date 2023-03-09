package io.algostrategy.client.coinex;

import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import io.algostrategy.client.coinex.domain.market.MarketInfo;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Coinex API facade, supporting asynchronous/non-blocking access Coinex's REST API.
 */
public interface CoinexApiAsyncRestClient {

    // General endpoints

    /**
     * Get all supported assets (asynchronous).
     *
     * @return assets
     */
    CompletableFuture<Response<Map<String, Asset>>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets (asynchronous).
     *
     * @return market info
     */
    CompletableFuture<Response<Map<String, MarketInfo>>> getMarketInfo();
}