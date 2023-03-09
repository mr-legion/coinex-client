package io.algostrategy.client.coinex;

import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import io.algostrategy.client.coinex.domain.market.MarketInfo;
import io.algostrategy.client.coinex.domain.market.MarketTickerResponse;
import io.algostrategy.client.coinex.domain.market.OrderBook;

import java.util.Map;

/**
 * Coinex API facade, supporting synchronous/blocking access Coinex's REST API.
 */
public interface CoinexApiRestClient {

    // General endpoints

    /**
     * Get all supported assets.
     *
     * @return assets
     */
    Response<Map<String, Asset>> getAssets();

    // Market endpoints

    /**
     * Get all supported markets.
     *
     * @return market info
     */
    Response<Map<String, MarketInfo>> getMarketInfo();

    /**
     * Get market tickers information.
     *
     * @return market tickers
     */
    Response<MarketTickerResponse> getMarketTickers();

    /**
     * Get orderbook for the market.
     *
     * @param market   market symbol (e.g. BTCUSDT)
     * @param limit    depth of the order book. Valid limits: [5, 10, 20, 50].
     * @param aggLevel market depth aggregation level
     * @return orderbook
     */
    Response<OrderBook> getOrderBook(String market, Integer limit, String aggLevel);
}