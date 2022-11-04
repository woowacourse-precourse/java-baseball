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

    @Test
    void strikeToStringTest() {
        Result result = new Result();
        assertThat(result.strikeToString()).isEqualTo(null);
        result.addStrike();
        String answer = "1스트라이크";
        assertThat(result.strikeToString()).isEqualTo(answer);
    }

    @Test
    void toStringTest() {
        Result result = new Result();
        String answer = "낫싱";
        assertThat(result.toString()).isEqualTo(answer);
        result.addBall();
        result.addBall();
        result.addStrike();
        answer = "2볼 1스트라이크";
        assertThat(result.toString()).isEqualTo(answer);
    }

    @Test
    void checkFinishTest() {
        Result result = new Result();
        result.addStrike();
        boolean answer = false;
        assertThat(result.checkFinish()).isEqualTo(answer);
        result.addStrike();
        result.addStrike();
        answer = true;
        assertThat(result.checkFinish()).isEqualTo(answer);
    }
}
