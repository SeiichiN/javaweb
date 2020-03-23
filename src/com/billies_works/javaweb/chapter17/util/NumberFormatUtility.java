package com.billies_works.javaweb.chapter17.util;

import java.text.NumberFormat;

public class NumberFormatUtility {

    public static String formatCurrency( int price ) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}
