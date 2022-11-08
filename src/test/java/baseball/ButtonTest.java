package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtonTest {

    @Test
    void reStart() {
        Button button = new Button("1");

        assertTrue(button.reStart());
    }

    @Test
    void wrong_input() {
        assertThrows(BallInputException.class, () -> new Button("3"));
    }


}