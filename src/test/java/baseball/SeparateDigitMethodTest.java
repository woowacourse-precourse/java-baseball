package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeparateDigitMethodTest {
    @Test
    void separateDigit_반환값_테스트1() {
        ArrayList<Integer> answer = new ArrayList<>(List.of(1, 2, 3));
        ArrayList<Integer> result = Application.separateDigit(123);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void separateDigit_반환값_테스트2() {
        ArrayList<Integer> answer = new ArrayList<>(List.of(7, 8, 9));
        ArrayList<Integer> result = Application.separateDigit(789);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void separateDigit_반환값_테스트3() {
        ArrayList<Integer> answer = new ArrayList<>(List.of(1, 3, 2));
        ArrayList<Integer> result = Application.separateDigit(132);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void separateDigit_반환값_테스트4() {
        ArrayList<Integer> answer = new ArrayList<>(List.of(5, 1, 4));
        ArrayList<Integer> result = Application.separateDigit(514);
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void separateDigit_반환값_테스트5() {
        ArrayList<Integer> answer = new ArrayList<>(List.of(1, 4, 8));
        ArrayList<Integer> result = Application.separateDigit(148);
        assertThat(result).isEqualTo(answer);
    }
}