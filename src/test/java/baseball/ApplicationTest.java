package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("세 자리를 초과한 숫자를 입력한 경우 예외 발생")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("세 자리 미만의 숫자를 입력한 경우 예외 발생")
    void inputNumberSizeUnderThree() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자 사이에 공백이 있을 경우 예외 발생")
    void inputNumberHasSpace() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자가 아닌 것을 사용자가 입력한 경우 예외 발생")
    void inputNumberIsNotNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자에 0이 있을 시 예외 발생")
    void inputNumberHasZero() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 종료 후 1, 2를 제외한 다른 숫자를 입력 시 예외 발생")
    void restartInputNumberIsNotOneOrTwo() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(
                        () -> {
                            run("135", "3");
                        },
                        1, 3, 5
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
