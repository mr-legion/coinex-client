package io.algostrategy.client.coinex;

import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import io.algostrategy.client.coinex.domain.market.MarketInfo;
import io.algostrategy.client.coinex.domain.market.MarketTickerResponse;
import io.algostrategy.client.coinex.domain.market.OrderBook;

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

    /**
     * Get market tickers information (asynchronous).
     *
     * @return market tickers
     */
    CompletableFuture<Response<MarketTickerResponse>> getMarketTickers();

    /**
     * Get orderbook for the market (asynchronous).
     *
     * @param market   market symbol (e.g. BTCUSDT)
     * @param limit    depth of the order book. Valid limits: [5, 10, 20, 50].
     * @param aggLevel market depth aggregation level
     * @return orderbook
     */
    CompletableFuture<Response<OrderBook>> getOrderBook(String market, Integer limit, String aggLevel);
}