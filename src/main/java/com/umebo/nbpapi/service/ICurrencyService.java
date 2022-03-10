package com.umebo.nbpapi.service;

import com.umebo.nbpapi.exception.InvalidCurrencyCodeException;

import java.math.BigDecimal;
import java.util.List;

public interface ICurrencyService {
    List<BigDecimal> getRatesFromLastDays(String currencyCode, int days) throws InvalidCurrencyCodeException;
}
