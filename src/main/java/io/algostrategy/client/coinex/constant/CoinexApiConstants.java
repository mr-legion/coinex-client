package io.algostrategy.client.coinex.constant;

import lombok.experimental.UtilityClass;

/**
 * Constants used throughout CoinEz's API.
 */
@UtilityClass
public class CoinexApiConstants {

    /**
     * Base domain.
     */
    public static final String BASE_DOMAIN = "coinex.com";

    /**
     * REST API base URL.
     */
    public static final String API_BASE_URL = "https://api." + BASE_DOMAIN;

    // Market depth aggregation level
    public static final String AGG_LEVEL_0 = "0";
    public static final String AGG_LEVEL_1 = "0.1";
    public static final String AGG_LEVEL_2 = "0.01";
    public static final String AGG_LEVEL_3 = "0.001";
    public static final String AGG_LEVEL_4 = "0.0001";
    public static final String AGG_LEVEL_5 = "0.00001";
    public static final String AGG_LEVEL_6 = "0.000001";
    public static final String AGG_LEVEL_7 = "0.0000001";
    public static final String AGG_LEVEL_8 = "0.00000001";
}