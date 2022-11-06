package baseball.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void calculateBallCount() {
        Integer strikeCount = 3;
        Integer ballCount = 0;

        Result result = new Result(3, 0);
        result.countStrike("123", "123");

        assertThat(result.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(result.getBallCount()).isEqualTo(ballCount);
    }

    @Test
    void countStrike() {
        Integer strikeCount = 3;

        Result result = new Result(3, 0);
        result.countStrike("123", "123");

        assertThat(result.getStrikeCount()).isEqualTo(strikeCount);
    }

    @Test
    void countBall() {
        Integer ballCount = 0;

        Result result = new Result(3, 0);
        result.countStrike("123", "123");

        assertThat(result.getBallCount()).isEqualTo(ballCount);
    }

    @Test
    void getStrikeCount() {
        Integer result = 3;

        Result strikeCount = new Result(3, 0);

        assertThat(strikeCount.getStrikeCount()).isEqualTo(result);
    }

    @Test
    void getBallCount() {
        Integer result = 2;

        Result ballCount = new Result(1, 2);

        assertThat(ballCount.getBallCount()).isEqualTo(result);
    }

    @Test
    void isNothing() {
        boolean result = true;

        Result ballCount = new Result(0, 0);

        assertThat(ballCount.isNothing()).isEqualTo(result);
    }

    @Test
    void isOut() {
        boolean result = true;

        Result ballCount = new Result(3, 0);

        assertThat(ballCount.isOut()).isEqualTo(result);
    }
}