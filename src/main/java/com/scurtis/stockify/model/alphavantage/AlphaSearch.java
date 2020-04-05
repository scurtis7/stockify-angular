package com.scurtis.stockify.model.alphavantage;

import lombok.Data;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@Data
public class AlphaSearch {

    private String symbol;
    private String name;
    private String type;
    private String region;
    private String timezone;
    private String currency;

}
