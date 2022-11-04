package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleReaderTest {

    @Test
    void readInteger() {
        String userInput = "123";

        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        Integer readInteger = ConsoleReader.readInteger();

        assertThat(readInteger).isEqualTo(Integer.parseInt(userInput));
    }
}