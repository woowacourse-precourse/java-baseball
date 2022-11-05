package baseball.common.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {

    @Override
    public String format(LogRecord logRecord) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String date = LocalDateTime.now().format(dateFormat);

        StringBuilder sb = new StringBuilder();
        sb.append(date);
        sb.append(" [");
        sb.append(logRecord.getLevel());
        sb.append("] ");
        sb.append(logRecord.getMessage());
        sb.append("\n");

        return sb.toString();
    }
}
