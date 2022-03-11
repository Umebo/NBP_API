package com.umebo.nbpapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umebo.nbpapi.model.GoldData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GoldRatesProviderTest {

    @Autowired
    GoldRatesProvider goldRatesProvider;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void ShouldReturnFourteenRatesFromCorrectCurrencyCode() throws JsonProcessingException {
        int days = 14;

        GoldData.Price[] goldDataArray = mapper.readValue(
                goldRatesProvider.GetLastGoldRates(days),
                GoldData.Price[].class);

        Assert.assertEquals(List.of(goldDataArray).size(), days);
    }
}
