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
        int[] answer = {5,3,2};
        int[] input = {3,2,1};
        int[] count = new int[2];
        List<Integer> answerNumber = Arrays.stream(answer).boxed().collect(Collectors.toList());
        List<Integer> inputNumber = Arrays.stream(input).boxed().collect(Collectors.toList());

        // when
        NumberBaseBallGame.countStrikeAndBall(count, answerNumber, inputNumber);

        // then
        assertThat(count[0]).isEqualTo(0);
        assertThat(count[1]).isEqualTo(2);
    }

    @Test
    void 스트라이크_볼_판정_계산_테스트2() {
        // given
        int[] answer = {5,3,2};
        int[] input = {5,3,2};
        int[] count = new int[2];
        List<Integer> answerNumber = Arrays.stream(answer).boxed().collect(Collectors.toList());
        List<Integer> inputNumber = Arrays.stream(input).boxed().collect(Collectors.toList());

        // when
        NumberBaseBallGame.countStrikeAndBall(count, answerNumber, inputNumber);

        // then
        assertThat(count[0]).isEqualTo(3);
        assertThat(count[1]).isEqualTo(0);
    }

    @Test
    void 스트라이크_볼_판정_계산_테스트3() {
        // given
        int[] answer = {6,1,3};
        int[] input = {7,4,5};
        int[] count = new int[2];
        List<Integer> answerNumber = Arrays.stream(answer).boxed().collect(Collectors.toList());
        List<Integer> inputNumber = Arrays.stream(input).boxed().collect(Collectors.toList());

        // when
        NumberBaseBallGame.countStrikeAndBall(count, answerNumber, inputNumber);

        // then
        assertThat(count[0]).isEqualTo(0);
        assertThat(count[1]).isEqualTo(0);
    }
}
