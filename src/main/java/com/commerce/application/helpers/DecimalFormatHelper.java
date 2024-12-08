package com.commerce.application.helpers;

import java.text.DecimalFormat;

public class DecimalFormatHelper {

    public static Float formatWithTwoDecimal(Float decimalNumber){
        DecimalFormat df = new DecimalFormat("###,##");
        return Float.parseFloat(df.format(decimalNumber));
    }
}
