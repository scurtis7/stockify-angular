package com.scurtis.stockify;

import com.scurtis.stockify.config.StockifyProperties;
import com.scurtis.stockify.converter.StockifyConverter;
import com.scurtis.stockify.webservice.AlphaVantageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles(value = "dev")
class ApplicationTests {

    @Autowired
    private StockifyProperties stockifyProperties;
    @Autowired
    private AlphaVantageService alphaVantageService;
    @Autowired
    private StockifyConverter stockifyConverter;

    @Test
    void contextLoads() {
        assertNotNull(stockifyConverter);
        assertNotNull(alphaVantageService);
        assertNotNull(stockifyProperties);
    }

}
