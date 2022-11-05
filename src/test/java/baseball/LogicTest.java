package baseball;

import game.NumberBaseBallGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LogicTest {

    @Test
    void 스트라이크_볼_판정_계산_테스트1() {
        // given
        int[] count = new int[2];
        List<Integer> answerNumber = List.of(5, 3, 2);
        List<Integer> inputNumber = List.of(3, 2, 1);

        // when
        NumberBaseBallGame.countStrikeAndBall(count, answerNumber, inputNumber);

        // then
        assertThat(count[0]).isEqualTo(0);
        assertThat(count[1]).isEqualTo(2);
    }

    @Test
    void 스트라이크_볼_판정_계산_테스트2() {
        // given
        int[] count = new int[2];
        List<Integer> answerNumber = List.of(5, 3, 2);
        List<Integer> inputNumber = List.of(5, 3, 2);

        // when
        NumberBaseBallGame.countStrikeAndBall(count, answerNumber, inputNumber);

        // then
        assertThat(count[0]).isEqualTo(3);
        assertThat(count[1]).isEqualTo(0);
    }

    @Test
    void 스트라이크_볼_판정_계산_테스트3() {
        // given
        int[] count = new int[2];
        List<Integer> answerNumber = List.of(6, 1, 3);
        List<Integer> inputNumber = List.of(7, 4, 5);

        // when
        NumberBaseBallGame.countStrikeAndBall(count, answerNumber, inputNumber);

        // then
        assertThat(count[0]).isEqualTo(0);
        assertThat(count[1]).isEqualTo(0);
    }
}
