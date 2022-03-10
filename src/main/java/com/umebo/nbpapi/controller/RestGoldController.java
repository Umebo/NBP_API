package com.umebo.nbpapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.umebo.nbpapi.service.IGoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/api/gold-price")
public class RestGoldController {

    @Autowired
    IGoldService goldService;
    private int GOLD_DAYS_NUM = 14;

    @GetMapping("/average")
    @ResponseBody
    public BigDecimal GetLast14GoldRatesAvr() throws JsonProcessingException {
        return goldService.GetLastGoldRatesAvr(GOLD_DAYS_NUM);
    }

}
