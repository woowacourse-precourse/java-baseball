package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    @DisplayName("스트라이크 추가")
    void addStrike() {
        int result = 1;
        Ball ball = new Ball(0, 0);

        ball.addStrike();
        assertEquals(result, ball.getStrike());
    }

    @Test
    @DisplayName("볼 추가")
    void addBall() {
        int result = 1;
        Ball ball = new Ball(0, 0);

        ball.addBall();
        assertEquals(result, ball.getBall());
    }
}