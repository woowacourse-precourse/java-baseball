package baseball.application.config;

import baseball.application.io.Reader;
import baseball.application.io.Writer;
import baseball.infrastructure.reader.ConsoleReader;
import baseball.infrastructure.writer.ConsoleWriter;

public class BaseBallGameConfig {

    public Writer writer() {
        return new ConsoleWriter();
    }

    public Reader reader() {
        return new ConsoleReader();
    }
}
