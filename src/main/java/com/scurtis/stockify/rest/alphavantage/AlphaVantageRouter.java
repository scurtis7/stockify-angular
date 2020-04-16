package com.scurtis.stockify.rest.alphavantage;

import com.scurtis.stockify.webservice.AlphaVantageService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Author: Steve Curtis
 * Date: Apr 08, 2020
 **/

@Configuration
@RequiredArgsConstructor
public class AlphaVantageRouter {

    private final SearchHandler searchHandler;
    private final StockQuoteHandler stockQuoteHandler;
    private final AlphaVantageService alphaVantageService;

    @Bean
    RouterFunction<ServerResponse> searchSymbolRoute() {
        return route(GET("/alpha/search/{symbol}"), searchHandler);
    }

    @Bean
    RouterFunction<ServerResponse> getQuoteRoute() {
        return route(GET("/alpha/quote/{symbol}"), stockQuoteHandler);
    }

}
