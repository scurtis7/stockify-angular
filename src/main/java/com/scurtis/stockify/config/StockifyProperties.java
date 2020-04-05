package com.scurtis.stockify.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;

import static org.springframework.util.Assert.notNull;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@Setter
@ConfigurationProperties(prefix = "com.scurtis.stockify")
public class StockifyProperties {

    private String alphaApiKey;

    @PostConstruct
    public void postConstruct() {
        notNull(alphaApiKey, "com.scurtis.stockify.apikey property must be set and may not be null");
    }

    public String getAlphaApiKey() {
        return "&apikey=" + alphaApiKey;
    }

}
