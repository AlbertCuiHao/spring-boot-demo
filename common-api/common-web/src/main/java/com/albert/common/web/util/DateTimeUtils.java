package com.albert.common.web.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {
    private DateTimeUtils() {
    }

    private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    public static String getString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
        return format.format(date);
    }

    public static String getString(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
        return date.format(dateTimeFormatter);
    }

    public static String getString(LocalTime time) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT);
        return time.format(dateTimeFormatter);
    }

    public static String getString(LocalDateTime date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT);
        return date.format(dateTimeFormatter);
    }


}
