package baseball.DB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {

    private LocalDateTime tryDate;
    private int tryCount;
    String dateFormat;

    public Data(LocalDateTime tryDate, int tryCount) {
        this.tryDate = tryDate;
        this.tryCount = tryCount;
        this.dateFormat = this.tryDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
    }

    @Override
    public String toString() {
        return "시도 날짜 : " + dateFormat + ", 시도 횟수 : " + tryCount;
    }
}
