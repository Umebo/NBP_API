package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.exception.InvalidCurrencyCodeException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CurrencyServiceTest {

    @Autowired
    CurrencyService currencyService;

    @Test
    public void CurrencyFromTableATest() throws InvalidCurrencyCodeException {
        String currencyCode = "USD";
        Assert.assertEquals("a", this.currencyService.getCurrencyTableName(currencyCode));
    }

    @Test
    public void CurrencyFromTableBTest() throws InvalidCurrencyCodeException {
        String currencyCode = "BOB";
        Assert.assertEquals("b", this.currencyService.getCurrencyTableName(currencyCode));
    }

    @Test(expected = InvalidCurrencyCodeException.class)
    public void InvalidCurrencyTest() throws InvalidCurrencyCodeException {
        String currencyCode = "x12";
        currencyService.getCurrencyTableName(currencyCode);
    }

}
