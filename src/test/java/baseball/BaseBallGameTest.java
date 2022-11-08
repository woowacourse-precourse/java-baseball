package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseBallGameTest {
    BaseBallGame baseBallGame = new BaseBallGame();

    @Test
    public void playerInputValidationTest(){
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Validation.validate("111")),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Validation.validate("201")),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Validation.validate("a93")),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> Validation.validate("112"))
        );
    }
}
