package com.umebo.nbpapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.umebo.nbpapi.model.GoldData;

import java.math.BigDecimal;

public interface IGoldService {
    BigDecimal GetLastXGoldRatesAvr(int days) throws JsonProcessingException;
    BigDecimal getGoldAvr (GoldData goldData);
}
