package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 볼만_나온_상황() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("324", "316", "351", "135", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_크기가_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자가_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자가_실수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자가_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("049"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_재시작_숫자가_문자() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("246", "135", "a"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트_재시작_숫자가_실수() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("246", "135", "1.5"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트_재시작_숫자가_0() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("246", "135", "0"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
