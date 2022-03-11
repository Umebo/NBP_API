package com.umebo.nbpapi.model.enums;

import java.util.stream.Stream;

public enum DailyUpdatedCurrencyTableA {
    USD, AUD, HKD, CAD, NZD, SGD, EUR, HUF, CHF, GBP,
    UAH, JPY, CZK, DKK, ISK, NOK, SEK, HRK, RON, BGN,
    TRY, ILS, CLP, PHP, MXN, ZAR, BRL, MYR, RUB, IDR,
    INR, KRW, CNY, XDR;

    public static boolean contains(String code) {
        return Stream.of(DailyUpdatedCurrencyTableA.values())
                .anyMatch(c -> c.name().equals(code.toUpperCase()));
    }
}
