package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiClientFactory;
import io.algostrategy.client.coinex.CoinexApiRestClient;
import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import io.algostrategy.client.coinex.domain.market.MarketInfo;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CoinexApiRestClientImplTest {

    private final CoinexApiRestClient coinexApiRestClient = CoinexApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        Response<Map<String, Asset>> response = coinexApiRestClient.getAssets();
        assertNotNull(response);
        assertThat(response.getData(), allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getMarketInfo_ShouldReturnMarketInfo() {
        Response<Map<String, MarketInfo>> response = coinexApiRestClient.getMarketInfo();
        assertNotNull(response);
        assertThat(response.getData(), allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }
}