package com.scurtis.stockify.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

@RestController
@RequestMapping("/stockify")
@RequiredArgsConstructor
@Slf4j
public class StockifyController {

    @PostMapping(value = "/stock/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String add(@PathVariable("symbol") String symbol) {
        log.info("Method: add({})", symbol);
        return "Success";
    }

}
