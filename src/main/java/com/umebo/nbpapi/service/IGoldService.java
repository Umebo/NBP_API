package com.umebo.nbpapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;

public interface IGoldService {
    BigDecimal GetLastGoldRatesAvr(int days) throws JsonProcessingException;
}
