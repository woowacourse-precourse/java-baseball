package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountBallAndStrikeTest {
    private final CounterBaseball counterBaseball = new CounterBaseball();

    @Test
    void 결과_낫싱() {
        String number = "456";
        List<Character> baseballNumber = List.of('1', '2', '3');
        counterBaseball.countBallAndStrike(baseballNumber, number);
        int strike = 0;
        int ball = 0;
        assertThat(counterBaseball.getStrike()).isEqualTo(strike);
        assertThat(counterBaseball.getBall()).isEqualTo(ball);
    }

    @Test
    void 결과_정답() {
        String number = "123";
        List<Character> baseballNumber = List.of('1', '2', '3');
        counterBaseball.countBallAndStrike(baseballNumber, number);
        int strike = 3;
        int ball = 0;
        assertThat(counterBaseball.getStrike()).isEqualTo(strike);
        assertThat(counterBaseball.getBall()).isEqualTo(ball);
    }

    @Test
    void 결과_스트라이크만존재() {
        String number = "526";
        List<Character> baseballNumber = List.of('1', '2', '3');
        counterBaseball.countBallAndStrike(baseballNumber, number);
        int strike = 1;
        int ball = 0;
        assertThat(counterBaseball.getStrike()).isEqualTo(strike);
        assertThat(counterBaseball.getBall()).isEqualTo(ball);
    }

    @Test
    void 결과_볼만존재() {
        String number = "231";
        List<Character> baseballNumber = List.of('1', '2', '3');
        counterBaseball.countBallAndStrike(baseballNumber, number);
        int strike = 0;
        int ball = 3;
        assertThat(counterBaseball.getStrike()).isEqualTo(strike);
        assertThat(counterBaseball.getBall()).isEqualTo(ball);
    }

    @Test
    void 결과_볼_스트라이크_존재_1() {
        String number = "293";
        List<Character> baseballNumber = List.of('1', '2', '3');
        counterBaseball.countBallAndStrike(baseballNumber, number);
        int strike = 1;
        int ball = 1;
        assertThat(counterBaseball.getStrike()).isEqualTo(strike);
        assertThat(counterBaseball.getBall()).isEqualTo(ball);
    }

    @Test
    void 결과_볼_스트라이크_존재_2() {
        String number = "852";
        List<Character> baseballNumber = List.of('5', '8', '2');
        counterBaseball.countBallAndStrike(baseballNumber, number);
        int strike = 1;
        int ball = 2;
        assertThat(counterBaseball.getStrike()).isEqualTo(strike);
        assertThat(counterBaseball.getBall()).isEqualTo(ball);
    }

    @Test
    void 결과_볼_스트라이크_존재_3() {
        String number = "548";
        List<Character> baseballNumber = List.of('5', '8', '2');
        counterBaseball.countBallAndStrike(baseballNumber, number);
        int strike = 1;
        int ball = 1;
        assertThat(counterBaseball.getStrike()).isEqualTo(strike);
        assertThat(counterBaseball.getBall()).isEqualTo(ball);
    }
}
