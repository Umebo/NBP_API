package com.umebo.nbpapi.controllers;

import com.umebo.nbpapi.data.CurrencyData;
import com.umebo.nbpapi.data.TableA;
import com.umebo.nbpapi.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/exchangerates")
public class RestCurrencyController {

    @Autowired
    ICurrencyService currencyService;

    @Resource
    CurrencyData currencyData;

    @GetMapping("/{currencyCode}")
    public void GetLast5CurrencyRates(@PathVariable String currencyCode) {
        String table = "";
        for (TableA code : TableA.values()) {
            if (currencyCode.equalsIgnoreCase(String.valueOf(code))) {
                table = "a";
                break;
            }
            else table = "b";
        }
        String url = "http://api.nbp.pl/api/exchangerates/rates/" +
                    table + "/" +
                    currencyCode + "/last/5";
        RestTemplate restTemplate = new RestTemplate();
        CurrencyData result = restTemplate.getForObject(url, CurrencyData.class);
        currencyData.setTable(result.getTable());
        currencyData.setCurrency(result.getCurrency());
        currencyData.setCode(result.getCode());
        currencyData.setRates(result.getRates());
    }

    @GetMapping("/last5")
    public void showLast5CurrencyRates() {
        System.out.print(currencyService.printDateAndValue());
    }

}
