package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TurnResultTest {

    @Test
    void compare_oneBall() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(591);

        List<Integer> inputs = Arrays.asList(275, 829, 712);
        inputs.forEach(it -> assertThat(
                TurnResult.compare(baseballNum, it).toString())
                .isEqualTo("1볼")
        );
    }

    @Test
    void compare_twoBall() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(287);
        List<Integer> inputs = Arrays.asList(178, 729, 672, 823, 758);
        inputs.forEach(it -> assertThat(
                TurnResult.compare(baseballNum, it).toString())
                .isEqualTo("2볼")
        );
    }

    @Test
    void compare_threeBall() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(291);
        List<Integer> inputs = Arrays.asList(129, 912);
        inputs.forEach(it -> assertThat(
                TurnResult.compare(baseballNum, it).toString())
                .isEqualTo("3볼")
        );
    }

    @Test
    void compare_oneStrike() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(123);
        List<Integer> inputs = Arrays.asList(156, 527, 943);
        inputs.forEach(it -> assertThat(
                TurnResult.compare(baseballNum, it).toString())
                .isEqualTo("1스트라이크")
        );
    }

    @Test
    void compare_twoStrike() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(517);
        List<Integer> inputs = Arrays.asList(519, 514, 217, 617, 527, 587);
        inputs.forEach(it -> assertThat(
                TurnResult.compare(baseballNum, it).toString())
                .isEqualTo("2스트라이크")
        );
    }

    @Test
    void compare_threeStrike() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(289);
        assertThat(TurnResult.compare(baseballNum, 289).toString()).isEqualTo("3스트라이크");
    }

    @Test
    void compare_oneBall_oneStrike() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(981);
        List<Integer> inputs = Arrays.asList(912, 978, 183, 289, 831, 791);
        inputs.forEach(it -> assertThat(
                TurnResult.compare(baseballNum, it).toString())
                .isEqualTo("1볼 1스트라이크")
        );
    }

    @Test
    void compare_twoBall_oneStrike() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(725);
        List<Integer> inputs = Arrays.asList(752, 527, 275);
        inputs.forEach(it -> assertThat(
                TurnResult.compare(baseballNum, it).toString())
                .isEqualTo("2볼 1스트라이크")
        );
    }

    @Test
    void compare_nothing() throws BaseballNum.NotBaseballNumException {
        BaseballNum baseballNum = new BaseballNum(281);
        List<Integer> inputs = Arrays.asList(935, 476, 365, 756, 796, 497, 576, 693);
        inputs.forEach(it -> assertThat(
                TurnResult.compare(baseballNum, it).toString())
                .isEqualTo("낫싱")
        );
    }
}
