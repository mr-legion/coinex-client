package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiAsyncRestClient;
import io.algostrategy.client.coinex.CoinexApiClientFactory;
import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import io.algostrategy.client.coinex.domain.market.MarketInfo;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CoinexApiAsyncRestClientImplTest {

    private final CoinexApiAsyncRestClient coinexApiAsyncRestClient =
            CoinexApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Response<Map<String, Asset>> response = coinexApiAsyncRestClient.getAssets().get();
        assertNotNull(response);
        assertThat(response.getData(), allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() throws ExecutionException, InterruptedException {
        Response<Map<String, MarketInfo>> response = coinexApiAsyncRestClient.getMarketInfo().get();
        assertNotNull(response);
        assertThat(response.getData(), allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }
}