package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComparisonTest {
    @Test
    void 스트라이크() {
        List<Integer> testNum1 = List.of(1, 2, 3);
        List<Integer> testNum2 = List.of(1, 2, 3);
        List<Integer> resultNum = List.of(3, 0);
        assertThat(Comparison.compare(testNum1, testNum2)).isEqualTo(resultNum);
    }

    @Test
    void 스트라이크_볼() {
        List<Integer> testNum1 = List.of(1, 2, 3);
        List<Integer> testNum2 = List.of(1, 3, 2);
        List<Integer> resultNum = List.of(1, 2);
        assertThat(Comparison.compare(testNum1, testNum2)).isEqualTo(resultNum);
    }

    @Test
    void 볼() {
        List<Integer> testNum1 = List.of(1, 2, 3);
        List<Integer> testNum2 = List.of(4, 3, 2);
        List<Integer> resultNum = List.of(0, 2);
        assertThat(Comparison.compare(testNum1, testNum2)).isEqualTo(resultNum);
    }

    @Test
    void 낫싱() {
        List<Integer> testNum1 = List.of(1, 2, 3);
        List<Integer> testNum2 = List.of(5, 6, 7);
        List<Integer> resultNum = List.of(0, 0);
        assertThat(Comparison.compare(testNum1, testNum2)).isEqualTo(resultNum);
    }

}
