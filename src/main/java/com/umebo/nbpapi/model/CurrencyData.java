package com.umebo.nbpapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CurrencyData {

    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    @Data
    public static class Rate {
        @JsonAlias("no")
        private String tableNumber;
        @JsonAlias("effectiveDate")
        private String date;
        @JsonAlias("mid")
        private BigDecimal middleExchangeRate;
    }
}
