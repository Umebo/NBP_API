package com.umebo.nbpapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umebo.nbpapi.data.GoldData;
import com.umebo.nbpapi.service.IGoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/gold-price")
public class RestGoldController {

    @Autowired
    IGoldService goldService;

    @Resource
    GoldData goldData;

    @GetMapping("/average")
    public void GetLast14GoldRates() throws JsonProcessingException {
        String url = "http://api.nbp.pl/api/cenyzlota/last/14";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        GoldData.price[] goldDataArray = mapper.readValue(response, GoldData.price[].class);
        goldData.setPrices(List.of(goldDataArray));
        System.out.print("\n" + goldService.getGoldAvr());
    }

}
