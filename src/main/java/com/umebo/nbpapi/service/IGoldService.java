package com.umebo.nbpapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;

public interface IGoldService {
    void GetLastXGoldRatesAvr(int days) throws JsonProcessingException;
    BigDecimal getGoldAvr ();
}
