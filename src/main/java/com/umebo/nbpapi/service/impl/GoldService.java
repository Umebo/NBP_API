package com.umebo.nbpapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umebo.nbpapi.model.GoldData;
import com.umebo.nbpapi.service.IGoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class GoldService implements IGoldService {

    @Autowired
    GoldRatesProvider goldRatesProvider;
    private ObjectMapper mapper = new ObjectMapper();

    public BigDecimal GetLastXGoldRatesAvr(int days) throws JsonProcessingException {
        GoldData goldData = new GoldData();
        GoldData.price[] goldDataArray = mapper.readValue(
                goldRatesProvider.GetLastXGoldRates(days),
                GoldData.price[].class);
        goldData.setPrices(List.of(goldDataArray));
        return getGoldAvr(goldData);
    }

    public BigDecimal getGoldAvr (GoldData goldData) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (int i = 0; i<goldData.getPrices().size(); i++) {
            total = total.add(goldData.getPrices().get(i).getPrice());
        }
        return total.divide(BigDecimal.valueOf(goldData.getPrices().size()), RoundingMode.HALF_EVEN);
    }

}
