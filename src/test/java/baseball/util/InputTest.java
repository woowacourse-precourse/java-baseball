package baseball.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    private Input aInput;

    @BeforeEach
    void setUp() {
        aInput = new Input();
    }

    @Test
    void readUserInput() {
    }

    @Test
    void setUserInput() {
        String afterInput = "123";

        aInput.setUserInput(afterInput);

        assertThat(afterInput).isEqualTo(aInput.getUserInput());
    }
}