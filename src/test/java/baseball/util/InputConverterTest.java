package baseball.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputConverterTest {

    @Test
    void 잘못된_입력시_예외발생() {
        String inputString = "1234";
        assertThrows(IllegalArgumentException.class,
                () -> {
                    InputConverter.stringToInteger(inputString);
                });

    }
}