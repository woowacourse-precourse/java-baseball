package baseball.domain.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void 볼_갯수_테스트() {
        int ball1 = 1;
        int ball2 = 2;
        int ball3 = 3;
        int strike = 0;
        Result result1 = new Result(ball1, strike);
        Result result2 = new Result(ball2, strike);
        Result result3 = new Result(ball3, strike);

        assertAll(
                () -> assertThat(result1.toString()).isEqualTo("1볼"),
                () -> assertThat(result2.toString()).isEqualTo("2볼"),
                () -> assertThat(result3.toString()).isEqualTo("3볼")
        );
    }

    @Test
    void 스트라이크_갯수_테스트() {
        int ball = 0;
        int strike1 = 1;
        int strike2 = 2;
        int strike3 = 3;
        Result result1 = new Result(ball, strike1);
        Result result2 = new Result(ball, strike2);
        Result result3 = new Result(ball, strike3);

        assertAll(
                () -> assertThat(result1.toString()).isEqualTo("1스트라이크"),
                () -> assertThat(result2.toString()).isEqualTo("2스트라이크"),
                () -> assertThat(result3.toString()).isEqualTo("3스트라이크")
        );
    }

    @Test
    void 볼_스트라이크_갯수_테스트() {
        int ball1 = 2;
        int ball2 = 1;
        int strike1 = 1;
        int strike2 = 2;
        Result result1 = new Result(ball1, strike1);
        Result result2 = new Result(ball2, strike2);

        assertAll(
                () -> assertThat(result1.toString()).isEqualTo("2볼 1스트라이크"),
                () -> assertThat(result2.toString()).isEqualTo("1볼 2스트라이크")
        );
    }

    @Test
    void 낫싱_테스트() {
        int ball = 0;
        int strike = 0;
        Result result = new Result(ball, strike);

        assertAll(
                () -> assertThat(result.toString()).isEqualTo("낫싱")
        );
    }
}