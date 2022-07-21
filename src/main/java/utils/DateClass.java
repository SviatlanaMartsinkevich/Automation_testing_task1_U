package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

public class DateClass {

    public String getTodayDate(String currentTimeZone) {
        LocalDate myDate = LocalDate.now(ZoneId.of(currentTimeZone));
        String convertedFormat = myDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String date = convertedFormat.concat(" - ").concat(convertedFormat);
        return date;
    }

    public String getYesterdayDate(String currentTimeZone) {
        LocalDate today = LocalDate.now(ZoneId.of(currentTimeZone));
        LocalDate yesterday = today.minus(Period.ofDays(1));
        String convertedFormat = yesterday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String date = convertedFormat.concat(" - ").concat(convertedFormat);
        return date;
    }

    public String getTomorrowDate(String currentTimeZone) {
        LocalDate today = LocalDate.now(ZoneId.of(currentTimeZone));
        LocalDate tomorrow = today.plus(Period.ofDays(1));
        String convertedFormat = tomorrow.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String date = convertedFormat.concat(" - ").concat(convertedFormat);
        return date;
    }

    public String getWeekDate(String currentTimeZone) {
        LocalDate today = LocalDate.now(ZoneId.of(currentTimeZone));
        LocalDate sunday = today.with(previousOrSame(SUNDAY));
        LocalDate saturday = today.with(nextOrSame(SATURDAY));
        String convertedFormatSunday = sunday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String convertedFormatSaturday = saturday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String date = convertedFormatSunday.concat(" - ").concat(convertedFormatSaturday);
        return date;
    }
}

