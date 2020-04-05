package com.scurtis.stockify.model.finnhub;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Author: Steve Curtis
 * Date: Apr 04, 2020
 **/

@Data
public class FinnQuote {
    @JsonProperty("c")
    private double close;
    @JsonProperty("h")
    private double high;
    @JsonProperty("l")
    private double low;
    @JsonProperty("o")
    private double open;
    @JsonProperty("pc")
    private double previousClose;
    @JsonProperty("t")
    private long timestamp;
}
