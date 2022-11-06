package baseball.domain;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {


    @Test
    @DisplayName("Balls 생성 성공 테스트")
    void createBallsTest() {
        Assertions.assertDoesNotThrow(() -> Balls.createBalls(Arrays.asList(1, 2, 3)));
    }

    @Test
    @DisplayName("Balls Size 예외 테스트")
    void sizeValidateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Balls.createBalls(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    @DisplayName("Balls 중복 예외 테스트")
    void duplicateValidateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Balls.createBalls(Arrays.asList(1, 3, 3)));
    }

    @Test
    @DisplayName("Balls Contain 테스트")
    void isContainTest() {
        Assertions.assertTrue(Balls.createBalls(Arrays.asList(1,2,3)).isContain(new Ball(1)));
    }

    @Test
    @DisplayName("Balls Contain 테스트")
    void isNotContainTest() {
        Assertions.assertFalse(Balls.createBalls(Arrays.asList(1,2,3)).isContain(new Ball(4)));
    }
}