package baseball.result;

import org.junit.jupiter.api.Test;

import static baseball.result.ResultType.*;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    void increaseStrike() {
        // given
        Result result = new Result();

        // when
        result.increaseStrike();

        // then
        assertThat(result.numberOfStrike()).isEqualTo(1);
        assertThat(result.numberOfBall()).isEqualTo(0);
        assertThat(result.getResultType()).isEqualTo(ONLY_STRIKE);
    }

    @Test
    void increaseBall() {
        // given
        Result result = new Result();

        // when
        result.increaseBall();

        // then
        assertThat(result.numberOfStrike()).isEqualTo(0);
        assertThat(result.numberOfBall()).isEqualTo(1);
        assertThat(result.getResultType()).isEqualTo(ONLY_BALL);
    }

    @Test
    void increaseStrikeAndBall() {
        // given
        Result result = new Result();

        // when
        result.increaseStrike();
        result.increaseBall();

        // then
        assertThat(result.numberOfStrike()).isEqualTo(1);
        assertThat(result.numberOfBall()).isEqualTo(1);
        assertThat(result.getResultType()).isEqualTo(BALL_AND_STRIKE);
    }

    @Test
    void strikeOut() {
        // given
        Result result = new Result();

        // when
        for (int i = 0; i < 3; i++)
            result.increaseStrike();

        // then
        assertThat(result.numberOfStrike()).isEqualTo(3);
        assertThat(result.getResultType()).isEqualTo(EXACT_MATCH);
    }

    @Test
    void nothing() {
        // given
        Result result = new Result();

        // then
        assertThat(result.numberOfStrike()).isEqualTo(0);
        assertThat(result.numberOfBall()).isEqualTo(0);
        assertThat(result.getResultType()).isEqualTo(NOTHING);
    }
}