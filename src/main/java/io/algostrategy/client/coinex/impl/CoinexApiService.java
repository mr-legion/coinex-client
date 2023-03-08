package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.Map;

/**
 * Coinex's REST API URL mappings.
 */
public interface CoinexApiService {

    // General endpoints

    @GET("/v1/common/asset/config")
    Call<Response<Map<String, Asset>>> getAssets();
}
