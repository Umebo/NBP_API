package com.umebo.nbpapi.controller;

import com.umebo.nbpapi.exception.InvalidCurrencyCodeException;
import com.umebo.nbpapi.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/exchangerates")
public class RestCurrencyController {

    @Autowired
    private ICurrencyService currencyService;
    private int STANDARD_DAYS_NUM = 5;

    @GetMapping("/{currencyCode}")
    public List<BigDecimal> getLast5CurrencyRates(@PathVariable String currencyCode) throws InvalidCurrencyCodeException {
        return currencyService.getRatesFromLastDays(currencyCode, STANDARD_DAYS_NUM);
    }

}
