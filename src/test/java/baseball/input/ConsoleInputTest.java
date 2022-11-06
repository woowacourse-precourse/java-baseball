package baseball.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputTest {

    private final UserInput consoleInput = new ConsoleInput();

    @Test
    void readAnswer() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = consoleInput.readAnswer();

        assertThat(result).isEqualTo("123");

    }

    @Test
    void readAnswerValidation() {
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, consoleInput::readAnswer);
    }

    @Test
    void readRetryable() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = consoleInput.readRetryable();

        assertThat(result).isEqualTo("1");
    }

    @Test
    void readRetryValidation() {
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, consoleInput::readRetryable);
    }
}