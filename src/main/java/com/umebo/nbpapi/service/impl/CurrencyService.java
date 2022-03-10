package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.exception.InvalidCurrencyCodeException;
import com.umebo.nbpapi.model.CurrencyData;
import com.umebo.nbpapi.model.DailyUpdatedCurrencyTableA;
import com.umebo.nbpapi.model.WeeklyUpdatedCurrencyTableB;
import com.umebo.nbpapi.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService implements ICurrencyService {

    @Autowired
    CurrencyRatesProvider currencyRatesProvider;

    public Map<String, BigDecimal> getDateAndValue(CurrencyData currencyData) {
        Map<String, BigDecimal> table = new HashMap<>();
        for (int i = 0; i<currencyData.getRates().size(); i++) {
            table.put(currencyData.getRates().get(i).getDate(),
                    currencyData.getRates().get(i).getMiddleExchangeRate());
        }
        return table;
    }

    public String chooseCurrencyTable (String currencyCode) throws InvalidCurrencyCodeException {
        if (DailyUpdatedCurrencyTableA.contains(currencyCode)) return  "a";
        else if (WeeklyUpdatedCurrencyTableB.contains(currencyCode)) return "b";
        else throw new InvalidCurrencyCodeException("Invalid currency code");
    }

    public Map<String, BigDecimal> getRatesFromLastXDays (String currencyCode, int days) throws InvalidCurrencyCodeException {
        String table = chooseCurrencyTable(currencyCode);
        CurrencyData result = currencyRatesProvider.getLastXDaysCurrencyData(currencyCode, table, days);
        return getDateAndValue(result);
    }

}