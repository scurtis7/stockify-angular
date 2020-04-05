package com.scurtis.stockify.converter;

import com.scurtis.stockify.model.alphavantage.AlphaSearch;
import com.scurtis.stockify.util.JsonReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

class StockifyConverterTest {

    private static final String BASE_PATH = "build/resources/test/";

    private JsonReader jsonReader = new JsonReader();
    private StockifyConverter stockifyConverter;

    private List<AlphaSearch> stockList;

    @Test
    void stockResultsAreCorrectlyConverted() {
        givenStockifyConverterConfigured();
        whenConvertStockDataCalled();
        thenResultsContainTheNumberOfResults(10);
    }

    @Test
    void emptyResultsReturnsEmptyList() {
        givenStockifyConverterConfigured();
        whenConvertStockDataCalledWithEmptyResults();
        thenResultsContainTheNumberOfResults(0);
    }

    @Test
    void emptyStringResultsReturnsEmptyList() {
        givenStockifyConverterConfigured();
        whenConvertStockDataCalledWithEmptyString();
        thenResultsContainTheNumberOfResults(0);
    }

    @Test
    void nullResultsReturnsEmptyList() {
        givenStockifyConverterConfigured();
        whenConvertStockDataCalledWithNull();
        thenResultsContainTheNumberOfResults(0);
    }

    private void givenStockifyConverterConfigured() {
        stockifyConverter = new StockifyConverter();
    }

    private void whenConvertStockDataCalled() {
        String stockSearchResults = jsonReader.readFile(BASE_PATH + "search-results.json");
        stockList = stockifyConverter.convertStockData(stockSearchResults);
    }

    private void whenConvertStockDataCalledWithEmptyResults() {
        String stockSearchResults = jsonReader.readFile(BASE_PATH + "search-results-empty.json");
        stockList = stockifyConverter.convertStockData(stockSearchResults);
    }

    private void whenConvertStockDataCalledWithEmptyString() {
        String stockSearchResults = "";
        stockList = stockifyConverter.convertStockData(stockSearchResults);
    }

    private void whenConvertStockDataCalledWithNull() {
        stockList = stockifyConverter.convertStockData(null);
    }

    private void thenResultsContainTheNumberOfResults(int resultSize) {
        assertEquals(resultSize, stockList.size());
    }

}
