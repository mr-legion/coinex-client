package io.algostrategy.client.coinex.impl;

import io.algostrategy.client.coinex.CoinexApiClientFactory;
import io.algostrategy.client.coinex.CoinexApiRestClient;
import io.algostrategy.client.coinex.domain.general.Asset;
import org.hamcrest.collection.IsMapWithSize;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CoinexApiRestClientImplTest {

    private final CoinexApiRestClient coinexApiRestClient = CoinexApiClientFactory.newInstance().newRestClient();

    @Test
    public void getAssets_ShouldReturnAssets() {
        Map<String, Asset> assets = coinexApiRestClient.getAssets().getData();
        assertThat(assets, allOf(notNullValue(), is(not(IsMapWithSize.anEmptyMap()))));
    }
}