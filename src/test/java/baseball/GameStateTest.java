package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameStateTest {
    @Test
    void 스트라이크_볼() {
        GameState strike = new GameState();
        GameState ball = new GameState();
        strike.addStrike();
        ball.addBall();
        assertThat(strike.getStrike()).isEqualTo(1);
        assertThat(ball.getBall()).isEqualTo(1);
    }
}