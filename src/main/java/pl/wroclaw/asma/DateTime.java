package pl.wroclaw.asma;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTime {

    static public String getActualDateTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").withLocale(Locale.ENGLISH);
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }

    public static String convertDate (long date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM").withLocale(Locale.ENGLISH);
        LocalDateTime convertedDate = LocalDateTime.ofEpochSecond(date, 0, ZoneOffset.UTC);
        return dateTimeFormatter.format(convertedDate);
    }

    public static String getDayName (long date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E").withLocale(Locale.ENGLISH);
        LocalDateTime convertedDate = LocalDateTime.ofEpochSecond(date, 0, ZoneOffset.UTC);
        return dateTimeFormatter.format(convertedDate).toUpperCase();
    }

}
