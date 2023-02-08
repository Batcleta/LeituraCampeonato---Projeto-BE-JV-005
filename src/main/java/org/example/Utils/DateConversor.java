package org.example.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConversor {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static LocalDate parse(String dateString) {
        return LocalDate.parse(dateString, formatter);
    }

    public static String format(LocalDate date) {
        return date.format(formatter);
    }

}
