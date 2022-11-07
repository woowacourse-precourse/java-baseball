package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class BallTest {

    ScoreDetect scoreDetect = new ScoreDetect();

    // 기능 요구사항
    // 3개일 필요 없다! 최대 3개
    // 0개일 경우 바로 종료
    // 그외 예외처리는 그대로
    // 두 리스트의 길이가 동일해야 함

    @Test
    void 볼_case1() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(scoreDetect.getBallCount(answer, numbers)).isEqualTo(0);
    }

    @Test
    void 볼_case2() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4, 5, 7));
        assertThat(scoreDetect.getBallCount(answer, numbers)).isEqualTo(1);
    }

    @Test
    void 볼_case3() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(6,8));
        assertThat(scoreDetect.getBallCount(answer, numbers)).isEqualTo(1);
    }

    @Test
    void 볼_case4() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(8, 9, 7));
        assertThat(scoreDetect.getBallCount(answer, numbers)).isEqualTo(3);
    }

    @Test
    void 볼_case5() {
        List<Integer> answer = new ArrayList<>(Arrays.asList());
        List<Integer> numbers = new ArrayList<>(Arrays.asList());
        assertThat(scoreDetect.getBallCount(answer, numbers)).isEqualTo(0);
    }

    @Test
    void 볼_case6_strike가_있는_경우() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7,8,9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7,9,6));
        assertThat(scoreDetect.getBallCount(answer, numbers)).isEqualTo(1);
    }

    @Test
    void 볼_error_answer_원소_수_4개() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(6, 7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8, 9));
        assertThatThrownBy(() -> scoreDetect.getBallCount(answer, numbers)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 볼_error_num_원소_수_4개() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8, 9, 6));
        assertThatThrownBy(() -> scoreDetect.getBallCount(answer, numbers)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 볼_error_길이가_다를경우() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8));
        assertThatThrownBy(() -> scoreDetect.getBallCount(answer, numbers)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 볼_error_10_이상의_수() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(7, 8, 10));
        assertThatThrownBy(() -> scoreDetect.getBallCount(answer, numbers)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 볼_error_숫자가_중복된_경우() {
        List<Integer> answer = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<Integer> numbers = new ArrayList<>(Arrays.asList(8, 8, 8));
        assertThatThrownBy(() -> scoreDetect.getBallCount(answer, numbers)).
                isInstanceOf(IllegalArgumentException.class);
    }
}
