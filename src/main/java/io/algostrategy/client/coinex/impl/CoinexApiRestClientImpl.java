package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiRestClient;
import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;

import java.util.Map;

/**
 * Implementation of Coinex's REST API using Retrofit with synchronous/blocking method calls.
 */
public class CoinexApiRestClientImpl implements CoinexApiRestClient {

    private final CoinexApiService coinexApiService;

    public CoinexApiRestClientImpl(CoinexApiService coinexApiService) {
        this.coinexApiService = coinexApiService;
    }

    // General endpoints

    @Override
    public Response<Map<String, Asset>> getAssets() {
        return CoinexApiServiceGenerator.executeSync(coinexApiService.getAssets());
    }
}
