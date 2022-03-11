package com.umebo.nbpapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoldData {

    @JsonAlias("data")
    private String date;

    @JsonAlias("cena")
    private BigDecimal price;
}
