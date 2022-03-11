package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.model.GoldData;
import com.umebo.nbpapi.service.IGoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class GoldService implements IGoldService {

    @Autowired
    private GoldRatesProvider goldRatesProvider;

    public BigDecimal GetLastGoldRatesAvr(int days) {
        GoldData[] goldDataArray = goldRatesProvider.GetLastGoldRates(days);
        return getGoldAvr(goldDataArray);
    }

    private BigDecimal getGoldAvr (GoldData[] goldDataArray) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (GoldData goldData : goldDataArray) {
            total = total.add(goldData.getPrice());
        }
        return total.divide(BigDecimal.valueOf(goldDataArray.length), RoundingMode.HALF_EVEN);
    }

}
