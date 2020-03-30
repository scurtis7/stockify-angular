package com.scurtis.stockify.model;

import lombok.Data;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@Data
public class StockSearch {

    private String symbol;
    private String name;
    private String type;
    private String region;
    private String timezone;
    private String currency;

}
