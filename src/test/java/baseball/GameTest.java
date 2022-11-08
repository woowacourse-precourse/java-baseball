package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    @DisplayName("입력값이 1 또는 2 이외의 값이면 예외를 던진다.")
    public void getInputNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            int inputNumber = 4;
            Game.isValidated(inputNumber);
        }, "예외가 발생하지 않았습니다.");
    }
}
