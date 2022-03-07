package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.data.CurrencyData;
import com.umebo.nbpapi.service.ICurrencyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService implements ICurrencyService {

    @Resource
    CurrencyData currencyData;

    public Map<String, BigDecimal> printDateAndValue () {
        Map<String, BigDecimal> table = new HashMap<>();
        for (int i = 0; i<currencyData.getRates().size(); i++) {
            table.put(currencyData.getRates().get(i).getEffectiveDate(),
                    currencyData.getRates().get(i).getMid());
        }
        return table;
    }

}
