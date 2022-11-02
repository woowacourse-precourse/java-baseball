package baseball.application.context;

import baseball.application.io.Reader;
import baseball.application.io.Writer;

public class BaseBallGameContext {

    private final Writer writer;
    private final Reader reader;

    public BaseBallGameContext(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public Writer writer() {
        return writer;
    }

    public Reader reader() {
        return reader;
    }

    public void init() {

    }
}
