package com.scurtis.stockify.config;

import com.scurtis.stockify.converter.StockifyConverter;
import com.scurtis.stockify.webservice.AlphaVantageService;
import com.scurtis.stockify.webservice.FinnHubService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@Configuration
public class StockifyConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

    @Bean
    public StockifyProperties stockifyProperties() {
        return new StockifyProperties();
    }

    @Bean
    public AlphaVantageService alphaVantageService(WebClient webClient, StockifyConverter converter, StockifyProperties properties) {
        return new AlphaVantageService(converter, properties);
    }

    @Bean
    public FinnHubService finnHubService(RestTemplate restTemplate, StockifyProperties properties) {
        return new FinnHubService(restTemplate, properties);
    }

    @Bean
    public StockifyConverter stockifyConverter() {
        return new StockifyConverter();
    }

    @Bean
    public RouterFunction<ServerResponse> htmlRouter(@Value("classpath:/public/index.html") Resource html) {
        return route(GET("/"),
                request -> ok()
                        .contentType(MediaType.TEXT_HTML)
                        .bodyValue(html)
        );
    }


}
