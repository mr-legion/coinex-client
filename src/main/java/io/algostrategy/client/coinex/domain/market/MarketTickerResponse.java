package io.algostrategy.client.coinex.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Market ticker wrapper.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTickerResponse {

    @JsonProperty("ticker")
    private Map<String, MarketTicker> tickers;

    @JsonProperty("date")
    private Long time;
}
