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
    private GoldRatesProvider goldRatesProvider;
    private ObjectMapper mapper = new ObjectMapper();

    public BigDecimal GetLastGoldRatesAvr(int days) throws JsonProcessingException {
        GoldData goldData = new GoldData();
        GoldData.Price[] goldDataArray = mapper.readValue(
                goldRatesProvider.GetLastGoldRates(days),
                GoldData.Price[].class);
        goldData.setPrices(List.of(goldDataArray));
        return getGoldAvr(goldData);
    }

    private BigDecimal getGoldAvr (GoldData goldData) {
        BigDecimal total = BigDecimal.valueOf(0);
        List<GoldData.Price> prices = goldData.getPrices();
        for (GoldData.Price price : prices) {
            total = total.add(price.getPrice());
        }
        return total.divide(BigDecimal.valueOf(prices.size()), RoundingMode.HALF_EVEN);
    }

}
