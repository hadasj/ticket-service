package com.hadasj.conversion;

import org.dozer.CustomConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeConverter implements CustomConverter {
    private static final ZoneId ZONE = ZoneId.of("Europe/Prague");

    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        if (sourceFieldValue instanceof LocalDateTime && destinationClass.equals(ZonedDateTime.class)) {
            // convert to ZonedDateTime
            LocalDateTime localDateTime = (LocalDateTime) sourceFieldValue;
            return localDateTime.atZone(ZONE);
        }
        return null;
    }
}
