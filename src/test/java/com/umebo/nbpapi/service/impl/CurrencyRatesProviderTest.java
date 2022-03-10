package com.umebo.nbpapi.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CurrencyRatesProviderTest {

    @Autowired
    CurrencyRatesProvider currencyRatesProvider;

    @Autowired
    CurrencyService currencyService;

    @Test
    public void CurrencyRatesNumberTest() {

    }
}
