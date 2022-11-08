package baseball.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultTest {

    @Test
    void countScore() {
        Result result = new Result(0, 0);
        result.countScore("123", "123");

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void getStrike() {
        int result = 1;
        Result result1 = new Result(1, 0);
        assertThat(result1.getStrike()).isEqualTo(result);
    }

    @Test
    void getBall() {
        int result = 2;
        Result result1 = new Result(1, 2);
        assertThat(result1.getBall()).isEqualTo(result);
    }

    @Test
    void isCorrect() {
        Result result = new Result(0, 0);
        result.countScore("123", "123");

        assertThat(result.isCorrect()).isEqualTo(true);
    }

    @Test
    void isNothing() {
        Result result = new Result(0, 0);
        result.countScore("123", "456");

        assertThat(result.isNothing()).isEqualTo(true);
    }
}