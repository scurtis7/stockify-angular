package com.scurtis.stockify.controller;

import com.scurtis.stockify.model.finnhub.FinnPriceTarget;
import com.scurtis.stockify.model.finnhub.FinnQuote;
import com.scurtis.stockify.webservice.FinnHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Steve Curtis
 * Date: Apr 05, 2020
 **/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/finn")
@RequiredArgsConstructor
public class FinnRestController {

    private final FinnHubService finnHubService;

    @GetMapping(value = "/quote/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FinnQuote quote(@PathVariable("symbol") String symbol) {
        return finnHubService.getQuote(symbol);
    }

    @GetMapping(value = "/price-target/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FinnPriceTarget getPriceTarget(@PathVariable("symbol") String symbol) {
        return finnHubService.getPriceTarget(symbol);
    }

}
