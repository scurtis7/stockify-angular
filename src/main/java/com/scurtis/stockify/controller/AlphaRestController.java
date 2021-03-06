package com.scurtis.stockify.controller;

import com.scurtis.stockify.webservice.AlphaVantageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/alpha")
@RequiredArgsConstructor
public class AlphaRestController {

    private final AlphaVantageService alphaVantageService;

//    @GetMapping(value = "/search/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<AlphaSearch> search(@PathVariable("symbol") String symbol) {
//        return alphaVantageService.search(symbol);
//    }

//    @GetMapping(value = "/quote/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public AlphaQuote quote(@PathVariable("symbol") String symbol) {
//        return alphaVantageService.getStockQuote(symbol);
//    }

}
