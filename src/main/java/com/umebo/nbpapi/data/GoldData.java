package com.umebo.nbpapi.data;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Data
public class GoldData {

    private List<price> prices;

    @Data
    public static class price {
        private String data;
        private BigDecimal cena;
    }
}
