package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임_중_입력_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input should be 3-digit integer with non-zero digits")
        );
    }

    @Test
    void 게임_중_입력_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input should be 3-digit integer with non-zero digits")
        );
    }

    @Test
    void 게임_중_입력_예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("131"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input should consist of non-duplicated digits")
        );
    }

    @Test
    void 게임_중_입력_예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1#2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input should be 3-digit integer with non-zero digits")
        );
    }

    @Test
    void 게임_중_입력_예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("+132"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input should be 3-digit integer with non-zero digits")
        );
    }

    @Test
    void 힌트_출력_테스트1() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 힌트_출력_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("145", "415", "451", "123", "2");
                    assertThat(output()).contains("1스트라이크", "1볼", "1볼", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 힌트_출력_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("627", "267", "172", "123", "2");
                    assertThat(output()).contains("1스트라이크", "1볼", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void 힌트_출력_테스트4() {
        assertRandomNumberInRangeTest(
                () -> {
                    runException("132", "124", "231", "123", "2");
                    assertThat(output()).contains("2볼 1스트라이크", "2스트라이크", "3볼", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
