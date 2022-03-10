package com.umebo.nbpapi.service;

import com.umebo.nbpapi.exception.InvalidCurrencyCodeException;
import com.umebo.nbpapi.model.CurrencyData;

import java.math.BigDecimal;
import java.util.Map;

public interface ICurrencyService {

    Map<String, BigDecimal> getDateAndValue(CurrencyData currencyData);
    String chooseCurrencyTable (String CurrencyCode) throws InvalidCurrencyCodeException;
    Map<String, BigDecimal> getRatesFromLastXDays (String currencyCode, int days) throws InvalidCurrencyCodeException;
}
