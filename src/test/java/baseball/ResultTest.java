package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ResultTest {

    @Test
    void 스트라이크_확인() {
        // given
        Result result = getResult("538", "555");

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
        Result result = getResult("558", "585");

        // then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void 낫싱_확인() {
        // given
        Result result = getResult("558", "123");

        // then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void 정답_확인() {
        // given
        Result result = getResult("558", "558");

        // then
        assertThat(result.getStrike()).isEqualTo(3);
    }

    Result getResult(String problem, String input) {
        Balls problem = new Balls();
        Balls input = new Balls();
        problem.convertInputToBall(problem);
        input.convertInputToBall(input);
        Result result = new Result();

        return result.getCompareResult(problem, input);
    }
}
