package com.umebo.nbpapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umebo.nbpapi.model.GoldDataArray;
import com.umebo.nbpapi.service.IGoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class GoldService implements IGoldService {

    @Autowired
    GoldRatesProvider goldRatesProvider;
    private ObjectMapper mapper = new ObjectMapper();

/*    public BigDecimal GetLastGoldRatesAvr(int days) throws JsonProcessingException {
        GoldData goldData = new GoldData();
        GoldData.Price[] goldDataArray = mapper.readValue(
                goldRatesProvider.GetLastXGoldRates(days),
                GoldData.Price[].class);
        goldData.setPrices(List.of(goldDataArray));
        return getGoldAvr(goldData);
    }*/

    public BigDecimal GetLastGoldRatesAvr(int days) throws JsonProcessingException {
        GoldDataArray goldDataArray = goldRatesProvider.GetLastGoldRates(days);
        return getGoldAvr(goldDataArray);
    }

    private BigDecimal getGoldAvr (GoldDataArray goldDataArray) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (int i = 0; i<goldDataArray.getPrices().size(); i++) {
            total = total.add(goldDataArray.getPrices().get(i).getPrice());
        }
        return total.divide(BigDecimal.valueOf(goldDataArray.getPrices().size()), RoundingMode.HALF_EVEN);
    }

}
