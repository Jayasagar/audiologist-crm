package com.audiologist.crm.utils;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public final class DateUtil {
    private DateUtil() {}

    public static DateTime getStartOfTheWeek() {
        LocalDate today = LocalDate.now();
        int old = today.getDayOfWeek();
        int monday = 1;

        if (monday <= old) {
            monday += 7;
        }
        LocalDate next = today.plusDays(monday - old);

        return next.toDateTimeAtStartOfDay();
    }
}
