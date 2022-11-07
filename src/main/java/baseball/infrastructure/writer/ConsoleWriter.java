package baseball.infrastructure.writer;

import baseball.application.io.Writer;

public class ConsoleWriter implements Writer {

    @Override
    public void println(Object message) {
        System.out.println(message);
    }

    @Override
    public void print(Object message) {
        System.out.print(message);
    }
}
