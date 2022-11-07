package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CountBallAndStrikeMethodTest {
    @Test
    void countBallAndStrike_반환값_테스트1() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> answer = new ArrayList<>(List.of(0, 3));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input1);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트2() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(4, 5, 6));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(5, 4, 6));
        ArrayList<Integer> answer = new ArrayList<>(List.of(2, 1));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트3() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(4, 5, 6));
        ArrayList<Integer> answer = new ArrayList<>(List.of(0, 0));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트4() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(7, 8, 9));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(9, 7, 8));
        ArrayList<Integer> answer = new ArrayList<>(List.of(3, 0));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트5() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(7, 8, 9));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(1, 2, 9));
        ArrayList<Integer> answer = new ArrayList<>(List.of(0, 1));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트6() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(3, 5, 7));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(9, 2, 1));
        ArrayList<Integer> answer = new ArrayList<>(List.of(0, 0));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트7() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(7, 8, 9));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(8, 7, 1));
        ArrayList<Integer> answer = new ArrayList<>(List.of(2, 0));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트8() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(3, 4, 5));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(1, 2, 6));
        ArrayList<Integer> answer = new ArrayList<>(List.of(0, 0));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트9() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 5));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(1, 2, 6));
        ArrayList<Integer> answer = new ArrayList<>(List.of(0, 2));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void countBallAndStrike_반환값_테스트10() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(3, 4, 5));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(9, 4, 1));
        ArrayList<Integer> answer = new ArrayList<>(List.of(0, 1));
        ArrayList<Integer> result = Application.countBallAndStrike(input1, input2);
        assertThat(result).isEqualTo(answer);
    }
}