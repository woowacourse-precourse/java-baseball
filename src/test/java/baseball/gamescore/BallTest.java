package baseball.gamescore;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    @Test
    void 볼2_맞는지_확인() {
        int correctCount = 3;
        int strike = 1;

        Ball ball = new Ball();
        int score = ball.score(correctCount, strike);

        int result = 2;
        assertThat(score).isEqualTo(result);
    }

    @Test
    void 볼1_맞는지_확인() {
        int correctCount = 3;
        int strike = 2;

        Ball ball = new Ball();
        int score = ball.score(correctCount, strike);

        int result = 1;
        assertThat(score).isEqualTo(result);
    }
}