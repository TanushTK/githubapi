package uitls;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUitls {
    public static String getTimeData() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH-mm-ss");
        return now.format(formatter);
    }
}
