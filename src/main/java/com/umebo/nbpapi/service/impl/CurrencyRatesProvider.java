package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.model.CurrencyData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Service
public class CurrencyRatesProvider {

    private static String BASE_URL = "http://api.nbp.pl/api/exchangerates/rates/%s/%s/last/%s";
    private RestTemplate restTemplate = new RestTemplate();

    public CurrencyData getLastDaysCurrencyData(String currencyCode, String table, int days) {
        String url = format(BASE_URL, table, currencyCode, days);
        return restTemplate.getForObject(url, CurrencyData.class);
    }
}
