package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class StrikeTest {

    ScoreDetect scoreDetect = new ScoreDetect();

    @Test
    void 스트라이크_case1() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(scoreDetect.getStrikeCount(answer, numbers)).isEqualTo(0);
    }

    @Test
    void 스트라이크_case2() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(9, 8, 7));
        assertThat(scoreDetect.getStrikeCount(answer, numbers)).isEqualTo(1);
    }

    @Test
    void 스트라이크_case3() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8, 6));
        assertThat(scoreDetect.getStrikeCount(answer, numbers)).isEqualTo(2);
    }

    @Test
    void 스트라이크_case4() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8, 9));
        assertThat(scoreDetect.getStrikeCount(answer, numbers)).isEqualTo(3);
    }

    @Test
    void 스트라이크_error_answer_원소_수_4개() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(6, 7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8, 9));
        assertThatThrownBy(() -> scoreDetect.getStrikeCount(answer, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크_error_num_원소_수_4개() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8, 9, 6));
        assertThatThrownBy(() -> scoreDetect.getStrikeCount(answer, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크_error_10_이상의_수() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8, 10));
        assertThatThrownBy(() -> scoreDetect.getStrikeCount(answer, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크_error_숫자가_중복된_경우() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(8, 8, 8));
        assertThatThrownBy(() -> scoreDetect.getStrikeCount(answer, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
