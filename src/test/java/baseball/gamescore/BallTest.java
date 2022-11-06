package baseball.gamescore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    @Test
    void 볼_개수_구하는_로직() {
        int correctCount = 3;
        int strike = 1;

        Ball ball = new Ball();
        int score = ball.score(correctCount, strike);

        int result = 2;
        assertThat(score).isEqualTo(result);
    }
}