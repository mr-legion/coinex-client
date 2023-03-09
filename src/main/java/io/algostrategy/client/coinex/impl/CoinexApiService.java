package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import io.algostrategy.client.coinex.domain.market.MarketInfo;
import io.algostrategy.client.coinex.domain.market.MarketTickerResponse;
import io.algostrategy.client.coinex.domain.market.OrderBook;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Map;

/**
 * Coinex's REST API URL mappings.
 */
public interface CoinexApiService {

    // General endpoints

    @GET("/v1/common/asset/config")
    Call<Response<Map<String, Asset>>> getAssets();

    // Market endpoints

    @GET("/v1/market/info")
    Call<Response<Map<String, MarketInfo>>> getMarketInfo();

    @GET("/v1/market/ticker/all")
    Call<Response<MarketTickerResponse>> getMarketTickers();

    @GET("/v1/market/depth")
    Call<Response<OrderBook>> getOrderBook(@Query("market") String market,
                                           @Query("limit") Integer limit,
                                           @Query("merge") String aggLevel);
}
