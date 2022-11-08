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
    void 게임종료_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 입력값_3글자아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_숫자_아닌_다른_글자_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_0포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("740"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임종료_후_잘못된_입력값() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "123"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 입력값_중복숫자포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("335"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
