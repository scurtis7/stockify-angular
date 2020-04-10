package com.scurtis.stockify.rest.finnhub;

import com.scurtis.stockify.webservice.FinnHubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Author: Steve Curtis
 * Date: Apr 09, 2020
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class FinnQuoteHandler implements HandlerFunction<ServerResponse> {

    private final FinnHubService finnHubService;

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        log.info("Method: handle()");
        return ServerResponse.ok().bodyValue(finnHubService.getQuote(request.pathVariable("symbol")));
    }

}
