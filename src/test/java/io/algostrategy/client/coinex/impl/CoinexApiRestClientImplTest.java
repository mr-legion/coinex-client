package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiClientFactory;
import io.algostrategy.client.coinex.CoinexApiRestClient;
import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;
import io.algostrategy.client.coinex.domain.market.MarketInfo;
import io.algostrategy.client.coinex.domain.market.MarketTickerResponse;
import io.algostrategy.client.coinex.domain.market.OrderBook;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.algostrategy.client.coinex.constant.CoinexApiConstants.AGG_LEVEL_0;
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

    @Test
    public void getMarketTickers_ShouldReturnMarketTickers() {
        Response<MarketTickerResponse> response = coinexApiRestClient.getMarketTickers();
        assertNotNull(response);
        assertThat(response.getData().getTickers(), allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }

    @Test
    public void getOrderBook_ShouldReturnOrderBookForBTCUSDT() {
        Response<OrderBook> response = coinexApiRestClient.getOrderBook("BTCUSDT", 50, AGG_LEVEL_0);
        assertNotNull(response);
        assertThat(response.getData().getAsks(), is(not(empty())));
        assertThat(response.getData().getBids(), is(not(empty())));
    }
}