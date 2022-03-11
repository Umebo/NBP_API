package com.umebo.nbpapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class GoldData {

    private List<Price> prices;

    @Data
    public static class Price {
        @JsonAlias("data")
        private String date;
        @JsonAlias("cena")
        private BigDecimal price;
    }
}
