package com.scurtis.stockify.model.finnhub;

import lombok.Data;

/**
 * Author: Steve Curtis
 * Date: Apr 05, 2020
 **/

@Data
public class FinnPriceTarget {
    private String lastUpdated;
    private String symbol;
    private int targetHigh;
    private int targetLow;
    private double targetMean;
    private int targetMedian;
}
