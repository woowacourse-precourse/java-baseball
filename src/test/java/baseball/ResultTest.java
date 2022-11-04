package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void constructorTest() {
        Result result = new Result();
        int answer = 0;
        assertThat(result.getBall()).isEqualTo(answer);
        assertThat(result.getStrike()).isEqualTo(answer);
    }

    @Test
    void addBallTest() {
        Result result = new Result();
        result.addBall();
        int answer = 1;
        assertThat(result.getBall()).isEqualTo(answer);
    }

    @Test
    void addStrikeTest() {
        Result result = new Result();
        result.addStrike();
        result.addStrike();
        int answer = 2;
        assertThat(result.getStrike()).isEqualTo(answer);
    }

    @Test
    void ballToStringTest() {
        Result result = new Result();
        assertThat(result.ballToString()).isEqualTo(null);
        result.addBall();
        result.addBall();
        String answer = "2볼";
        assertThat(result.ballToString()).isEqualTo(answer);
    }
}
