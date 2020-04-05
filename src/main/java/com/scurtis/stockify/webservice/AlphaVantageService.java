package com.scurtis.stockify.webservice;

import com.scurtis.stockify.config.StockifyProperties;
import com.scurtis.stockify.converter.StockifyConverter;
import com.scurtis.stockify.model.alphavantage.AlphaQuote;
import com.scurtis.stockify.model.alphavantage.AlphaSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.scurtis.stockify.config.AppConstants.ALPHA_VANTAGE_BASE_URL;
import static com.scurtis.stockify.config.AppConstants.FUNCTION_GLOBAL_QUOTE;
import static com.scurtis.stockify.config.AppConstants.FUNCTION_SYMBOL_SEARCH;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@RequiredArgsConstructor
@Slf4j
public class AlphaVantageService {

    private final RestTemplate restTemplate;
    private final StockifyConverter converter;
    private final StockifyProperties properties;

    public List<AlphaSearch> search(String keyword) {
        String url = ALPHA_VANTAGE_BASE_URL + FUNCTION_SYMBOL_SEARCH + "&keywords=" + keyword + properties.getAlphaApiKey();
        return converter.convertStockData(callWebservice(url));
    }

    public AlphaQuote getStockQuote(String symbol) {
        String url = ALPHA_VANTAGE_BASE_URL + FUNCTION_GLOBAL_QUOTE + "&symbol=" + symbol + properties.getAlphaApiKey();
        return converter.convertStockQuote(callWebservice(url));
    }

    private String callWebservice(String url) {
        log.info("Method: callWebservice({})", url);
        String response = restTemplate.getForEntity(url, String.class).getBody();
        if (StringUtils.isEmpty(response)) {
            log.error("Response is empty");
        } else if (response.contains("Error")) {
            log.error(response);
            response = "";
        }
        return response;
    }


}
