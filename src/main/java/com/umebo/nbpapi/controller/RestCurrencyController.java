package com.umebo.nbpapi.controller;

import com.umebo.nbpapi.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/exchangerates")
public class RestCurrencyController {

    @Autowired
    ICurrencyService currencyService;

    @GetMapping("/{currencyCode}")
    public Map<String, BigDecimal> getLast5CurrencyRates(@PathVariable String currencyCode) {
        currencyService.getRatesFromLastXDays(currencyCode, 5);
        return currencyService.getDateAndValue();
    }

}
