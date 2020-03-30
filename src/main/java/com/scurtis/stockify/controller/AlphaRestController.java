package com.scurtis.stockify.controller;

import com.scurtis.stockify.model.StockQuote;
import com.scurtis.stockify.model.StockSearch;
import com.scurtis.stockify.webservice.AlphaVantageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/alpha")
@RequiredArgsConstructor
public class AlphaRestController {

    private final AlphaVantageService alphaVantageService;

    @GetMapping(value = "/search/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StockSearch> search(@PathVariable("symbol") String symbol) {
        return alphaVantageService.search(symbol);
    }

    @GetMapping(value = "/quote/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public StockQuote quote(@PathVariable("symbol") String symbol) {
        return alphaVantageService.getStockQuote(symbol);
    }

}
