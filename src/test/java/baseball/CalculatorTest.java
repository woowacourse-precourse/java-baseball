package baseball;

import baseball.game.number.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.game.number.Calculator.scoreCalculator;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("스트라이크 1개")
    void case1() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,5,8);
        Score score = scoreCalculator(answer, userInput);

        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크 2개")
    void case2() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,2,8);
        Score score = scoreCalculator(answer, userInput);

        assertThat(score.getStrike()).isEqualTo(2);
        assertThat(score.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크 3개")
    void case3() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,2,3);
        Score score = scoreCalculator(answer, userInput);

        assertThat(score.getStrike()).isEqualTo(3);
        assertThat(score.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼 2개")
    void case4() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(3,9,1);
        Score score = scoreCalculator(answer, userInput);

        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("스트라이크 1개, 볼 1개")
    void case5() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,3,8);
        Score score = scoreCalculator(answer, userInput);

        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(1);
    }
}
