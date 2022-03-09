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

    @GetMapping("/average")
    @ResponseBody
    public BigDecimal GetLast14GoldRatesAvr() throws JsonProcessingException {
        goldService.GetLastXGoldRatesAvr(14);
        return goldService.getGoldAvr();
    }

}
