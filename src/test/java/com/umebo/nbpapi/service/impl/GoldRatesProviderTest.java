package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.model.GoldData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GoldRatesProviderTest {

    @Autowired
    GoldRatesProvider goldRatesProvider;

    @Test
    public void ShouldReturnFourteenRatesFromCorrectCurrencyCode() {
        int days = 14;

        GoldData[] goldDataArray = goldRatesProvider.GetLastGoldRates(days);

        Assert.assertEquals(goldDataArray.length, days);
    }
}
