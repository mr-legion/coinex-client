package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiAsyncRestClient;
import io.algostrategy.client.coinex.CoinexApiClientFactory;
import io.algostrategy.client.coinex.domain.general.Asset;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CoinexApiAsyncRestClientImplTest {

    private final CoinexApiAsyncRestClient coinexApiAsyncRestClient =
            CoinexApiClientFactory.newInstance().newAsyncRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() throws ExecutionException, InterruptedException {
        Map<String, Asset> assets = coinexApiAsyncRestClient.getAssets().get().getData();
        assertThat(assets, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }
}