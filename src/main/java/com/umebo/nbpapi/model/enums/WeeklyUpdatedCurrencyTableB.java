package com.umebo.nbpapi.model.enums;

import java.util.stream.Stream;

public enum WeeklyUpdatedCurrencyTableB {
    AFN, MGA, PAB, ETB, VES, BOB, CRC, SVC, NIO, GMD,
    MKD, DZD, BHD, IQD, JOD, KWD, LYD, RSD, TND, MAD,
    AED, STN, BSD, BBD, BZD, BND, FJD, GYD, JMD, LRD,
    NAD, SRD, TTD, XCD, SBD, ZWL, VND, AMD, CVE, AWG,
    BIF, XOF, XAF, XPF, DJF, GNF, KMF, CDF, RWF, EGP,
    GIP, LBP, SSP, SDG, SYP, GHS, HTG, PYG, ANG, PGK,
    LAK, MWK, ZMW, AOA, MMK, GEL, MDL, ALL, HNL, SLL,
    SZL, LSL, AZN, MZN, NGN, ERN, TWD, TMT, MRU, TOP,
    MOP, ARS, DOP, COP, CUP, UYU, BWP, GTQ, IRR, YER,
    QAR, OMR, SAR, KHR, BYN, RUB, LKR, MVR, MUR, NPR,
    PKR, SCR, PEN, KGS, TJS, UZS, KES, SOS, TZS, UGX,
    BDT, WST, KZT, MNT, VUV, BAM;

    public static boolean contains(String code) {
        return Stream.of(WeeklyUpdatedCurrencyTableB.values())
                .anyMatch(c -> c.name().equals(code.toUpperCase()));
    }
}
