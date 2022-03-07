package com.umebo.nbpapi.service.impl;

import com.umebo.nbpapi.data.GoldData;
import com.umebo.nbpapi.service.IGoldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class GoldService implements IGoldService {

    @Resource
    GoldData goldData;

    public void printAll () {
        for (int i=0; i<goldData.getPrices().size(); i++) {
            System.out.print(goldData.getPrices().get(i));
        }
    }

    public BigDecimal getGoldAvr () {
        BigDecimal total = BigDecimal.valueOf(0);
        for (int i = 0; i<goldData.getPrices().size(); i++) {
            total = total.add(goldData.getPrices().get(i).getCena());
        }
        return total.divide(BigDecimal.valueOf(goldData.getPrices().size()), RoundingMode.HALF_EVEN);
    }

}
