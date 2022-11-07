package baseball;

import baseball.ball.Ball;
import baseball.ball.BallResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BallTest {

    @Nested
    @DisplayName("숫자 범위 검사")
    class testBallRange {
        @Test
        @DisplayName("숫자 범위 안에 있어서 성공")
        void testValidateBall() {
            new Ball(1, 1);
        }

        @Test
        @DisplayName("숫자 범위 밖에 있어서 실패")
        void testFailValidateBall() {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Ball(0, 2));

            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Ball(8, 4));
        }
    }

    @Nested
    @DisplayName("숫자 하나 비교")
    class testCompare {
        @Test
        @DisplayName("낫싱 나오는 경우")
        void testCompareBallNothing() {
            Ball ball1 = new Ball(1, 1);
            Ball ball2 = new Ball(2, 1);

            assertThat(ball1.compare(ball2)).isEqualTo(BallResult.NOTHING);
        }

        @Test
        @DisplayName("볼 나오는 경우")
        void testCompareBallBall() {
            Ball ball1 = new Ball(2, 1);
            Ball ball2 = new Ball(2, 2);

            assertThat(ball1.compare(ball2)).isEqualTo(BallResult.BALL);
        }

        @Test
        @DisplayName("스트라이크 나오는 경우")
        void testCompareBallStrike() {
            Ball ball1 = new Ball(1, 1);
            Ball ball2 = new Ball(1, 1);

            assertThat(ball1.compare(ball2)).isEqualTo(BallResult.STRIKE);
        }
    }
}
