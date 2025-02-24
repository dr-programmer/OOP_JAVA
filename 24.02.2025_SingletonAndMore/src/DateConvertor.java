import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConvertor {
    private static DateConvertor instance;

    private DateConvertor() {}

    public static DateConvertor getInstance() {
        if (instance == null) {
            instance = new DateConvertor();
        }
        return instance;
    }

    public LocalDate convertStringToLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ldt = LocalDate.parse(date, formatter);
        return ldt;
    }
}
