package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GiveHintMethodTest {
    @Test
    void 힌트_반환값_테스트1() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        String answer = "3스트라이크";
        String result = Application.giveHint(input1, input1);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트2() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(2, 3, 1));
        String answer = "3볼 ";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트3() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(2, 3, 1));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(1, 2, 3));
        String answer = "3볼 ";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트4() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(7, 8, 9));
        String answer = "3스트라이크";
        String result = Application.giveHint(input1, input1);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트5() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(4, 5, 6));
        String answer = "낫싱";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트6() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(7, 8, 9));
        String answer = "낫싱";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트7() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(1, 2, 5));
        String answer = "2스트라이크";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트8() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(1, 3, 2));
        String answer = "2볼 1스트라이크";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트9() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(3, 2, 1));
        String answer = "2볼 1스트라이크";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트10() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(2, 4, 5));
        String answer = "1볼 ";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트11() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(1, 7, 9));
        String answer = "1스트라이크";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트12() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(1, 3, 9));
        String answer = "1볼 1스트라이크";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트13() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 4, 3));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(5, 4, 7));
        String answer = "1스트라이크";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트14() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(1, 4, 7));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(5, 4, 7));
        String answer = "2스트라이크";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 힌트_반환값_테스트15() {
        ArrayList<Integer> input1 = new ArrayList<>(List.of(4, 1, 7));
        ArrayList<Integer> input2 = new ArrayList<>(List.of(5, 4, 7));
        String answer = "1볼 1스트라이크";
        String result = Application.giveHint(input1, input2);
        assertThat(result).isEqualTo(answer);
    }
}