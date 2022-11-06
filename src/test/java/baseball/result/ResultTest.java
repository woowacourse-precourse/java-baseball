package baseball.result;

import org.junit.jupiter.api.Test;

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
        assertThat(result.getResultType()).isEqualTo(ResultType.ONLY_STRIKE);
    }
}