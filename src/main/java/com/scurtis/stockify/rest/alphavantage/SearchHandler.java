package com.scurtis.stockify.rest.alphavantage;

import com.scurtis.stockify.model.alphavantage.AlphaSearch;
import com.scurtis.stockify.webservice.AlphaVantageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Author: Steve Curtis
 * Date: Apr 09, 2020
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchHandler implements HandlerFunction<ServerResponse> {

    private final AlphaVantageService alphaVantageService;

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        log.info("Method: handle()");
        List<AlphaSearch> results = alphaVantageService.search(request.pathVariable("symbol"));
        return ServerResponse.ok().bodyValue(results);
    }

}
