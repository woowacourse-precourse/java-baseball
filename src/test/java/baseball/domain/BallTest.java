package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {


    @Test
    @DisplayName("Ball 생성 성공 테스트")
    void successBall() {
        Assertions.assertDoesNotThrow(() -> new Ball(1));
        Assertions.assertDoesNotThrow(() -> new Ball(9));
    }

    @Test
    @DisplayName("Ball 생성 예외 테스트")
    void rangeValidateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ball(10));
    }

}