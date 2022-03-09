package com.umebo.nbpapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umebo.nbpapi.model.GoldData;
import com.umebo.nbpapi.service.IGoldService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class GoldService implements IGoldService {

    @Resource
    GoldData goldData;

    public void GetLastXGoldRatesAvr(int days) throws JsonProcessingException {
        String url = "http://api.nbp.pl/api/cenyzlota/last/" + days;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        GoldData.price[] goldDataArray = mapper.readValue(response, GoldData.price[].class);
        goldData.setPrices(List.of(goldDataArray));
    }

    public BigDecimal getGoldAvr () {
        BigDecimal total = BigDecimal.valueOf(0);
        for (int i = 0; i<goldData.getPrices().size(); i++) {
            total = total.add(goldData.getPrices().get(i).getPrice());
        }
        return total.divide(BigDecimal.valueOf(goldData.getPrices().size()), RoundingMode.HALF_EVEN);
    }

}
