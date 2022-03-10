package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.exception.InvalidCurrencyCodeException;
import com.umebo.nbpapi.model.CurrencyData;
import com.umebo.nbpapi.model.DailyUpdatedCurrencyTableA;
import com.umebo.nbpapi.model.WeeklyUpdatedCurrencyTableB;
import com.umebo.nbpapi.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {

    @Autowired
    CurrencyRatesProvider currencyRatesProvider;

    public List<BigDecimal> getCurrencyValues(CurrencyData currencyData) {
        List<BigDecimal> table = new ArrayList<>();
        for (int i = 0; i<currencyData.getRates().size(); i++) {
            table.add(currencyData.getRates().get(i).getMiddleExchangeRate());
        }
        return table;
    }

    public String getCurrencyTableName(String currencyCode) throws InvalidCurrencyCodeException {
        if (DailyUpdatedCurrencyTableA.contains(currencyCode)) return  "a";
        else if (WeeklyUpdatedCurrencyTableB.contains(currencyCode)) return "b";
        else throw new InvalidCurrencyCodeException("Invalid currency code");
    }

    public List<BigDecimal> getRatesFromLastDays(String currencyCode, int days) throws InvalidCurrencyCodeException {
        String table = getCurrencyTableName(currencyCode);
        CurrencyData result = currencyRatesProvider.getLastDaysCurrencyData(currencyCode, table, days);
        return getCurrencyValues(result);
    }

}