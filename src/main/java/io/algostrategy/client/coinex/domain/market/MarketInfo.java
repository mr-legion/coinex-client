package io.algostrategy.client.coinex.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketInfo {

    @JsonProperty("name")
    private String symbol;

    @JsonProperty("trading_name")
    private String baseAsset;

    @JsonProperty("pricing_name")
    private String quoteAsset;

    @JsonProperty("min_amount")
    private Double minAmount;

    @JsonProperty("maker_fee_rate")
    private Double makerFee;

    @JsonProperty("taker_fee_rate")
    private Double takerFee;

    @JsonProperty("pricing_decimal")
    private Double pricingDecimal;

    @JsonProperty("trading_decimal")
    private Double tradingDecimal;
}
