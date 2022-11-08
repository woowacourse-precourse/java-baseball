package baseball;

import baseball.util.ArgumentExceptionMessage;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
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
    void 예외_테스트_길이가_짧을_떄() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ArgumentExceptionMessage.INPUT_UNCONFORMABLE_LENGTH.getMessage())
        );
    }

    @Test
    void 예외_테스트_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ArgumentExceptionMessage.INPUT_NOT_INTEGER.getMessage())
        );
    }

    @Test
    void 예외_테스트_일부_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12c"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ArgumentExceptionMessage.INPUT_NOT_INTEGER.getMessage())
        );
    }

    @Test
    void 예외_테스트_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ArgumentExceptionMessage.INPUT_OVERLAP.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
