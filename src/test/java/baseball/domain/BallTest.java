package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Nested
    class Test1 {
        final Ball ball = new Ball();

        @Test
        void ball() {
            assertAll(
                    () -> assertNotNull(ball),
                    () -> assertEquals(ball.ball(), 0)
            );
        }

        @ParameterizedTest()
        @ValueSource(ints = {1, 2, 3, 4, 0, 7})
        void addStrike(final int num) {
            ball.putBall(num);
            assertEquals(ball.ball(), num);
        }

        @Test
        void clearStrike() {
            ball.clearBall();
            assertEquals(ball.ball(), 0);
        }
    }

    @DisplayName("메소드 통합 테스트")
    @Test
    void IntegratedTest() {
        final var ball1 = new Ball();
        final var ball2 = new Ball();

        ball2.putBall(2);
        ball1.putBall(1);

        assertAll(
                () -> assertEquals(ball2.ball(), 2),
                () -> assertEquals(ball1.ball(), 1)
        );

        ball1.clearBall();
        ball2.clearBall();

        assertEquals(ball1.ball(), ball2.ball());
    }
}