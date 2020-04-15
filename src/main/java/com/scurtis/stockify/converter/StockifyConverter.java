package com.scurtis.stockify.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.stockify.model.alphavantage.AlphaQuote;
import com.scurtis.stockify.model.alphavantage.AlphaSearch;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@Slf4j
public class StockifyConverter {

    private ObjectMapper mapper = new ObjectMapper();

    private static final String NODE_SYMBOL = "1. symbol";
    private static final String NODE_NAME = "2. name";
    private static final String NODE_TYPE = "3. type";
    private static final String NODE_REGION = "4. region";
    private static final String NODE_TIMEZONE = "7. timezone";
    private static final String NODE_CURRENCY = "8. currency";

    public Flux<AlphaSearch> convertStockData(Mono<String> data) {
        log.info("Method: convertStockData()");
        List<AlphaSearch> searchResults = new ArrayList<>();
        return Flux.fromIterable(searchResults);
//        if (StringUtils.isEmpty(data)) {
//            return searchResults;
//        }
//
//        try {
//            JsonNode rootNode = mapper.readTree(data);
//            JsonNode stockNodes = rootNode.findValue("bestMatches");
//
//            if (stockNodes.isArray()) {
//                for (JsonNode arrayItem : stockNodes) {
//                    searchResults.add(convertArrayItemToStock(arrayItem));
//                }
//            }
//        } catch (JsonProcessingException exception) {
//            log.error("Exception while converting stock data: ", exception);
//        }
//
//        return searchResults;
    }

    public Mono<AlphaQuote> convertStockQuote(Mono<String> data) {
        log.info("Method: convertStockQuote()");
        return data.map(this::convertQuote).onErrorReturn(new AlphaQuote());
    }

    private AlphaSearch convertArrayItemToStock(JsonNode arrayItem) {
        AlphaSearch alphaSearch = new AlphaSearch();
        alphaSearch.setSymbol(arrayItem.get(NODE_SYMBOL).textValue());
        alphaSearch.setName(arrayItem.get(NODE_NAME).textValue());
        alphaSearch.setType(arrayItem.get(NODE_TYPE).textValue());
        alphaSearch.setRegion(arrayItem.get(NODE_REGION).textValue());
        alphaSearch.setTimezone(arrayItem.get(NODE_TIMEZONE).textValue());
        alphaSearch.setCurrency(arrayItem.get(NODE_CURRENCY).textValue());
        return alphaSearch;
    }

    private AlphaQuote convertQuote(String quote) {
        try {
            AlphaQuote alphaQuote = new AlphaQuote();
            JsonNode rootNode = mapper.readTree(quote);
            JsonNode stockQuoteNode = rootNode.findValue("Global Quote");

            alphaQuote.setSymbol(stockQuoteNode.get("01. symbol").textValue());
            alphaQuote.setOpen(stockQuoteNode.get("02. open").textValue());
            alphaQuote.setHigh(stockQuoteNode.get("03. high").textValue());
            alphaQuote.setLow(stockQuoteNode.get("04. low").textValue());
            alphaQuote.setPrice(stockQuoteNode.get("05. price").textValue());
            alphaQuote.setVolume(stockQuoteNode.get("06. volume").textValue());
            alphaQuote.setLastTradingDay(stockQuoteNode.get("07. latest trading day").textValue());
            alphaQuote.setPreviousClose(stockQuoteNode.get("08. previous close").textValue());
            alphaQuote.setChange(stockQuoteNode.get("09. change").textValue());
            alphaQuote.setChangePercent(stockQuoteNode.get("10. change percent").textValue());
            return alphaQuote;
        } catch (JsonProcessingException e) {
            return new AlphaQuote();
        }
    }

}
