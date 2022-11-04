package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static baseball.PlayerNumber.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerNumberTest {

    private static PlayerNumber playerNumber;

    @BeforeEach
    private void setUp() {
        playerNumber = new PlayerNumber();
    }

    @Test
    void 숫자_중복_검사() {
        String duplicationTestTrue = "123";
        String duplicationTestFalse = "133";
        assertTrue(duplicationCheck(duplicationTestTrue));
        assertFalse(duplicationCheck(duplicationTestFalse));
    }

    @Test
    void 숫자_길이_검사() {
        String lengthTestTrue = "123";
        String lengthTestFalse = "3";
        assertTrue(lengthCheck(lengthTestTrue));
        assertFalse(lengthCheck(lengthTestFalse));
    }

    @Test
    void 숫자_0이_있는지_검사() {
        String zeroTestTrue = "123";
        String zeroTestFalse = "012";
        assertTrue(zeroCheck(zeroTestTrue));
        assertFalse(zeroCheck(zeroTestFalse));
    }
}
