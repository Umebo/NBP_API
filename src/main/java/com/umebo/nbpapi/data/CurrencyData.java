package com.umebo.nbpapi.data;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Data
public class CurrencyData {

    private String table;
    private String currency;
    private String code;
    private List<rate> rates;

    @Data
    public static class rate {
        private String no;
        private String effectiveDate;
        private BigDecimal mid;
    }
}
