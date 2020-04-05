package com.scurtis.stockify.webservice;

import com.scurtis.stockify.config.StockifyProperties;
import com.scurtis.stockify.model.finnhub.FinnPriceTarget;
import com.scurtis.stockify.model.finnhub.FinnQuote;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import static com.scurtis.stockify.config.AppConstants.FINN_HUB_BASE_URL;

/**
 * Author: Steve Curtis
 * Date: Apr 04, 2020
 **/

@RequiredArgsConstructor
@Slf4j
public class FinnHubService {

    private final RestTemplate restTemplate;
    private final StockifyProperties properties;

    public FinnQuote getQuote(String symbol) {
        String url = FINN_HUB_BASE_URL + "/quote?symbol=" + symbol.toUpperCase() + properties.getFinnToken();
        log.info("getQuote => {}", url);
        return restTemplate.getForEntity(url, FinnQuote.class).getBody();
    }

    public FinnPriceTarget getPriceTarget(String symbol) {
        String url = FINN_HUB_BASE_URL + "/stock/price-target?symbol=" + symbol.toUpperCase() + properties.getFinnToken();
        log.info("getPriceTarget => {}", url);
        return restTemplate.getForEntity(url, FinnPriceTarget.class).getBody();
    }

}
