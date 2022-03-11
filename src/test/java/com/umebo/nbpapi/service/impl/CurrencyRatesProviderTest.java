package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.model.CurrencyData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CurrencyRatesProviderTest {

    @Autowired
    CurrencyRatesProvider currencyRatesProvider;

    @Test
    public void ShouldReturnFiveRatesFromCorrectCurrencyCode() {
        int days = 5;

        CurrencyData rates = currencyRatesProvider.getLastDaysCurrencyData("USD", "a", days);

        Assert.assertEquals(rates.getRates().size(), days);
    }
}
