package io.algostrategy.client.coinex;

import io.algostrategy.client.coinex.domain.Response;
import io.algostrategy.client.coinex.domain.general.Asset;

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
}