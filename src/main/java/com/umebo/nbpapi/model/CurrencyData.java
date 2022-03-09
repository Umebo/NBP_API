package com.umebo.nbpapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
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
        @JsonAlias("no")
        private String tableNumber;
        @JsonAlias("effectiveDate")
        private String date;
        @JsonAlias("mid")
        private BigDecimal middleExchangeRate;
    }
}
