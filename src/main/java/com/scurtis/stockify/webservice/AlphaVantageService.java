package com.scurtis.stockify.webservice;

import com.scurtis.stockify.config.StockifyProperties;
import com.scurtis.stockify.converter.StockifyConverter;
import com.scurtis.stockify.model.Stock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.scurtis.stockify.config.AppConstants.BASE_URL;
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

    public List<Stock> search(String keyword) {
        String url = BASE_URL + FUNCTION_SYMBOL_SEARCH + "&keywords=" + keyword + properties.getApikey();
        return converter.convertStockData(callWebservice(url).getBody());
    }

    private ResponseEntity<String> callWebservice(String url) {
        log.info("Method: callWebservice({})", url);
        return restTemplate.getForEntity(url, String.class);
    }


}
