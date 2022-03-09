package com.umebo.nbpapi.service;

import java.math.BigDecimal;
import java.util.Map;

public interface ICurrencyService {

    Map<String, BigDecimal> getDateAndValue();
    String chooseCurrencyTable (String CurrencyCode);
    void getRatesFromLastXDays (String currencyCode, int days);
}
