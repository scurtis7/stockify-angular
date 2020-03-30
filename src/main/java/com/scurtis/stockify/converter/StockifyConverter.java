package com.scurtis.stockify.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scurtis.stockify.model.StockQuote;
import com.scurtis.stockify.model.StockSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

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

    public List<StockSearch> convertStockData(String data) {
        log.info("Method: convertStockData()");
        List<StockSearch> searchResults = new ArrayList<>();
        if (StringUtils.isEmpty(data)) {
            return searchResults;
        }

        try {
            JsonNode rootNode = mapper.readTree(data);
            JsonNode stockNodes = rootNode.findValue("bestMatches");

            if (stockNodes.isArray()) {
                for (JsonNode arrayItem : stockNodes) {
                    searchResults.add(convertArrayItemToStock(arrayItem));
                }
            }
        } catch (JsonProcessingException exception) {
            log.error("Exception while converting stock data: ", exception);
        }

        return searchResults;
    }

    public StockQuote convertStockQuote(String data) {
        log.info("Method: convertStockQuote()");
        StockQuote stockQuote = new StockQuote();
        if (StringUtils.isEmpty(data)) {
            return stockQuote;
        }

        try {
            JsonNode rootNode = mapper.readTree(data);
            JsonNode stockQuoteNode = rootNode.findValue("Global Quote");

            stockQuote.setSymbol(stockQuoteNode.get("01. symbol").textValue());
            stockQuote.setOpen(stockQuoteNode.get("02. open").textValue());
            stockQuote.setHigh(stockQuoteNode.get("03. high").textValue());
            stockQuote.setLow(stockQuoteNode.get("04. low").textValue());
            stockQuote.setPrice(stockQuoteNode.get("05. price").textValue());
            stockQuote.setVolume(stockQuoteNode.get("06. volume").textValue());
            stockQuote.setLastTradingDay(stockQuoteNode.get("07. latest trading day").textValue());
            stockQuote.setPreviousClose(stockQuoteNode.get("08. previous close").textValue());
            stockQuote.setChange(stockQuoteNode.get("09. change").textValue());
            stockQuote.setChangePercent(stockQuoteNode.get("10. change percent").textValue());

        } catch (JsonProcessingException exception) {
            log.error("Exception while converting stock quote data: ", exception);
        }

        return stockQuote;
    }

    private StockSearch convertArrayItemToStock(JsonNode arrayItem) {
        StockSearch stockSearch = new StockSearch();
        stockSearch.setSymbol(arrayItem.get(NODE_SYMBOL).textValue());
        stockSearch.setName(arrayItem.get(NODE_NAME).textValue());
        stockSearch.setType(arrayItem.get(NODE_TYPE).textValue());
        stockSearch.setRegion(arrayItem.get(NODE_REGION).textValue());
        stockSearch.setTimezone(arrayItem.get(NODE_TIMEZONE).textValue());
        stockSearch.setCurrency(arrayItem.get(NODE_CURRENCY).textValue());
        return stockSearch;
    }

}
