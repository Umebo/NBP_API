package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.model.CurrencyData;
import com.umebo.nbpapi.model.CurrencyTableA;
import com.umebo.nbpapi.service.ICurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class CurrencyService implements ICurrencyService {

    @Resource
    CurrencyData currencyData;

    public Map<String, BigDecimal> getDateAndValue() {
        Map<String, BigDecimal> table = new HashMap<>();
        for (int i = 0; i<currencyData.getRates().size(); i++) {
            table.put(currencyData.getRates().get(i).getDate(),
                    currencyData.getRates().get(i).getMiddleExchangeRate());
        }
        return table;
    }

    public String chooseCurrencyTable (String currencyCode) {
        String table = "b";
        if (CurrencyTableA.stream().anyMatch(c
                -> currencyCode.equalsIgnoreCase(String.valueOf(c))))
            table = "a";
        return table;
    }

    public void getRatesFromLastXDays (String currencyCode, int days) {
        String table = chooseCurrencyTable(currencyCode);
        String url = "http://api.nbp.pl/api/exchangerates/rates/" +
                table + "/" +
                currencyCode + "/last/" +
                days;
        RestTemplate restTemplate = new RestTemplate();
        CurrencyData result = restTemplate.getForObject(url, CurrencyData.class);
        currencyData.setTable(Objects.requireNonNull(result).getTable());
        currencyData.setCurrency(result.getCurrency());
        currencyData.setCode(result.getCode());
        currencyData.setRates(result.getRates());
    }

}