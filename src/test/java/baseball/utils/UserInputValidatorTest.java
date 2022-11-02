package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputValidatorTest {

    @Test
    @DisplayName("입력 숫자는 총 3개")
    void 입력_숫자는_3개() {
        assertThrows(IllegalArgumentException.class, () -> UserInputValidator.isValidBalls(List.of(1, 2, 3, 4)));
    }

    @Test
    @DisplayName("입력 숫자는 중복된 숫자 불가")
    void 입력_숫자_중복불가() {
        assertThrows(IllegalArgumentException.class, () -> UserInputValidator.isValidBalls(List.of(1, 3, 3)));
    }

    @Test
    @DisplayName("입력은 숫자만 허용")
    void 입력은_숫자만_허용() {
        assertThrows(IllegalArgumentException.class, () -> UserInputValidator.isValidBallNo('h'));
    }

    @Test
    @DisplayName("입력은 1 ~ 9 사이의 수만 허용")
    void 입력_숫자_범위는_1에서_9까지() {
        assertThrows(IllegalArgumentException.class, () -> UserInputValidator.isValidBallNo((char) 0));
    }
}