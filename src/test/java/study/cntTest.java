package study;

import baseball.BaseballGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class cntTest {

    @Test
    @DisplayName("스트라이크 동작 확인")
    void strikeTest() {
        BaseballGame game = new BaseballGame();

        List<Integer> input = List.of(1, 2, 3);
        List<Integer> output = List.of(4, 2, 3);
        int strike = game.cntStrike(input, output);
        assertThat(strike).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 동작 확인")
    void ballTest() {
        BaseballGame game = new BaseballGame();

        List<Integer> input = List.of(1, 2, 3);
        List<Integer> output = List.of(4, 5, 2);
        int ball = game.cntBall(input, output);
        assertThat(ball).isEqualTo(1);
    }
}