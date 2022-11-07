package baseball;

import baseball.Comparison;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트_길이() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_범위() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
