package com.scurtis.stockify.rest.finnhub;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Author: Steve Curtis
 * Date: Apr 09, 2020
 **/

@Configuration
@RequiredArgsConstructor
public class FinnHubRouter {

    private final FinnQuoteHandler quoteHandler;
    private final FinnPriceTargetHandler priceTargetHandler;

    @Bean
    RouterFunction<ServerResponse> getQuote() {
        return route(GET("/finn/quote/{symbol}"), quoteHandler);
    }

    @Bean
    RouterFunction<ServerResponse> getPriceTarget() {
        return route(GET("/finn/price-target/{symbol}"), priceTargetHandler);
    }

//    @GetMapping(value = "/quote/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public FinnQuote quote(@PathVariable("symbol") String symbol) {
//        return finnHubService.getQuote(symbol);
//    }
//
//    @GetMapping(value = "/price-target/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public FinnPriceTarget getPriceTarget(@PathVariable("symbol") String symbol) {
//        return finnHubService.getPriceTarget(symbol);
//    }

}
