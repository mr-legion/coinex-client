package io.algostrategy.client.coinex.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Market ticker information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTicker {

    private Double last;

    @JsonProperty("sell")
    private Double askPrice;
    @JsonProperty("sell_amount")
    private Double askAmount;

    @JsonProperty("buy")
    private Double bidPrice;
    @JsonProperty("buy_amount")
    private Double bidAmount;

    private Double open;
    private Double low;
    private Double high;
    private Double vol;
}
