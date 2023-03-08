package io.algostrategy.client.coinex.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An asset.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {

    @JsonProperty("asset")
    private String symbol;

    private String chain;

    @JsonProperty("can_deposit")
    private Boolean depositEnabled;

    @JsonProperty("can_withdraw")
    private Boolean withdrawEnabled;

    @JsonProperty("withdraw_tx_fee")
    private Double withdrawFee;

    @JsonProperty("deposit_least_amount")
    private Double minDepositAmount;

    @JsonProperty("withdraw_least_amount")
    private Double minWithdrawAmount;

    @JsonProperty("withdrawal_precision")
    private Double withdrawPrecision;
}