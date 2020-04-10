package com.scurtis.stockify.webservice;

import com.scurtis.stockify.config.StockifyProperties;
import com.scurtis.stockify.converter.StockifyConverter;
import com.scurtis.stockify.model.alphavantage.AlphaQuote;
import com.scurtis.stockify.model.alphavantage.AlphaSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.scurtis.stockify.config.AppConstants.ALPHA_VANTAGE_BASE_URL;
import static com.scurtis.stockify.config.AppConstants.FUNCTION_GLOBAL_QUOTE;
import static com.scurtis.stockify.config.AppConstants.FUNCTION_SYMBOL_SEARCH;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@Slf4j
@RequiredArgsConstructor
public class AlphaVantageService {

    private WebClient webClient;
    private final StockifyConverter converter;
    private final StockifyProperties properties;

    public List<AlphaSearch> search(String keyword) {
        log.info("Method: search('{}')", keyword);
        String url = ALPHA_VANTAGE_BASE_URL + FUNCTION_SYMBOL_SEARCH + "&keywords=" + keyword + properties.getAlphaApiKey();
        String response = getWebClient().get().uri(url).retrieve().bodyToMono(String.class).block();
        return converter.convertStockData(response);
    }

    public AlphaQuote getStockQuote(String symbol) {
        log.info("Method: getStockQuote('{}')", symbol);
        String url = ALPHA_VANTAGE_BASE_URL + FUNCTION_GLOBAL_QUOTE + "&symbol=" + symbol + properties.getAlphaApiKey();
        String response = getWebClient().get().uri(url).retrieve().bodyToMono(String.class).block();
        return converter.convertStockQuote(response);
    }

    private WebClient getWebClient() {
        if (webClient == null) {
            webClient = WebClient.create();
        }
        return webClient;
    }

}
