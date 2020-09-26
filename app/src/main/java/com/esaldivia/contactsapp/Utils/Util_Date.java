package com.esaldivia.contactsapp.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util_Date {

    public static final String MONTH_NAME = "MMMM";
    public static final String DAY_YEAR = "d, yyyy";

    /**
     * parses date to a sentence form string
     * @param date
     * @return formatDate
     */
    public static String dateToString(Date date) {
        SimpleDateFormat month_date = new SimpleDateFormat(MONTH_NAME, Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_YEAR, Locale.ENGLISH);

        String month_name = month_date.format(date);
        return month_name.toUpperCase(Locale.ENGLISH) + " " + sdf.format(date);
    }
}
