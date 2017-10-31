package io.ferreyra.blinkist_code_challege.persistance.utils;

import android.arch.persistence.room.TypeConverter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Created by carlos on 10/31/17.
 */

public class Converters {
    @TypeConverter
    public static DateTime fromTimestamp(Long value) {
        return value == null ? null : new DateTime(value).toDateTime(DateTimeZone.UTC);
    }

    @TypeConverter
    public static Long dateTimeToTimestamp(DateTime date) {
        return date == null ? null : date.getMillis();
    }
}

