package baseball.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[Ball 클래스 테스트]")
class BallTest {

    @DisplayName("단위 메소드 테스트")
    @Nested
    class Test1 {
        final Ball ball = new Ball();

        @Test
        @DisplayName("ball 객체가 잘 생성실되었는가?")
        void strike() {
            assertAll(
                    () -> assertNotNull(ball),
                    () -> assertEquals(ball.ball(), 0)
            );
        }

        @ParameterizedTest()
        @DisplayName("ball 객체의 ball 메소드가 잘 실행되는가?")
        @ValueSource(ints = {1, 2, 3, 4, 0, 7})
        void addStrike(final int num) {
            for(int i = 0; i < num; i++) {
                ball.addBall();
            }
            assertEquals(ball.ball(), num);
        }

        @Test
        @DisplayName("ball 객체의 clearBall 메소드가 잘 실행되는가?")
        void clearStrike() {
            ball.clearBall();
            assertEquals(ball.ball(), 0);
        }
    }

    @Test
    @DisplayName("통합적으로 Ball 클래스가 제대로 실행되는가?")
    void IntegratedTest() {
        final Ball ball1 = new Ball();
        final Ball ball2 = new Ball();

        ball2.addBall();
        ball2.addBall();

        ball1.addBall();

        assertAll(
                () -> assertEquals(ball2.ball(), 2),
                () -> assertEquals(ball1.ball(), 1)
        );

        ball1.clearBall();
        ball2.clearBall();

        assertEquals(ball1.ball(), ball2.ball());
    }
}