package com.scurtis.stockify.model;

import lombok.Data;

/**
 * Author: Steve Curtis
 * Date: Mar 29, 2020
 **/

@Data
public class StockQuote {

    private String symbol;
    private String open;
    private String high;
    private String low;
    private String price;
    private String volume;
    private String lastTradingDay;
    private String previousClose;
    private String change;
    private String changePercent;

}
