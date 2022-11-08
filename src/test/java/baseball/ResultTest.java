package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ResultTest {

    @Test
    void 스트라이크_확인() {
        // given
        Result result = getResult("538", "521");

        // then
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void 볼_확인() {
        // given
        Result result = getResult("538", "352");

        // then
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void 스트라이크_볼_확인() {
        // given
        Result result = getResult("518", "589");

        // then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void 낫싱_확인() {
        // given
        Result result = getResult("548", "123");

        // then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void 정답_확인() {
        // given
        Result result = getResult("548", "548");

        // then
        assertThat(result.getStrike()).isEqualTo(3);
    }

    Result getResult(String stringOfProblem, String stringOfInput) {
        CollectionBalls problem = new CollectionBalls();
        CollectionBalls input = new CollectionBalls();
        problem.convertInputToBall(stringOfProblem);
        input.convertInputToBall(stringOfInput);
        Result result = new Result();
        result.getCompareResult(problem, input);
        return result;
    }
}
