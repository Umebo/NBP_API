package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.config.AppConfiguration;
import com.umebo.nbpapi.exception.InvalidCurrencyCodeException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfiguration.class})
public class CurrencyServiceTest {

    @Autowired
    CurrencyService currencyService;

    @Test
    public void CurrencyFromTableATest() throws InvalidCurrencyCodeException {
        String currencyCode = "USD";
        Assert.assertEquals("a", this.currencyService.chooseCurrencyTable(currencyCode));
    }

    @Test
    public void CurrencyFromTableBTest() throws InvalidCurrencyCodeException {
        String currencyCode = "BOB";
        Assert.assertEquals("b", this.currencyService.chooseCurrencyTable(currencyCode));
    }

    @Test(expected = InvalidCurrencyCodeException.class)
    public void InvalidCurrencyTest() throws InvalidCurrencyCodeException {
        String currencyCode = "x12";
        currencyService.chooseCurrencyTable(currencyCode);
    }
}
