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
    private String finnToken;

    @PostConstruct
    public void postConstruct() {
        notNull(alphaApiKey, "com.scurtis.stockify.alphaApiKey property must be set and may not be null");
        notNull(finnToken, "com.scurtis.stockify.finnToken property must be set and may not be null");
    }

    public String getAlphaApiKey() {
        return "&apikey=" + alphaApiKey;
    }

    public String getFinnToken() {
        return "&token=" + finnToken;
    }

}
