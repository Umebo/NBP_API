package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.model.GoldData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Service
public class GoldRatesProvider {

    private static String BASE_URL = "http://api.nbp.pl/api/cenyzlota/last/%s";
    private RestTemplate restTemplate = new RestTemplate();

    public GoldData[] GetLastGoldRates(int days) {
        String url = format(BASE_URL, days);
        return restTemplate.getForObject(url, GoldData[].class);
    }
}
