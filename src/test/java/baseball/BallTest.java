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

    @Test
    @DisplayName("게임 끝났는지")
    void isEnd() {
        Ball ball = new Ball(3, 0);

        assertTrue(ball.isEnd());
    }

    @Test
    @DisplayName("결과 출력")
    void testToString() {
        String result = "1볼 2스트라이크";
        Ball ball = new Ball(2, 1);

        assertEquals(result, ball.toString());
    }
}