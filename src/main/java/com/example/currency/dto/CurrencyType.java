package com.example.currency.dto;

import java.util.ArrayList;
import java.util.List;

public enum CurrencyType {
    EUR, USD, GBP, NZD, AUD, JPY, UAH;

    public static final List<String> names() {
        final List<String> str = new ArrayList<>(values().length);
        for (CurrencyType currencyType: values() ) {
            str.add(currencyType.name());
        }
        return str;
    }
}
