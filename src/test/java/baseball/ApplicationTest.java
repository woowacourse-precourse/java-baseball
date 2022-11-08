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

    @DisplayName("정상 종료 후 재시작 안할 경우")
    @Test
    void case1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "215", "134", "135", "2");
                    assertThat(output()).contains("낫싱", "1볼 1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @DisplayName("게임 종료 후 재시작 입력 과정에서 올바르지 않은 값 입력할 경우")
    @Test
    void case2() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() ->
                                run("369", "3"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("Only 1 and 2 can be entered."),
                3, 6, 9
        );
    }

    @DisplayName("게임 도중 사용자의 잘못된 입력으로 예외 발생(0 포함한 경우)")
    @Test
    void case3() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() ->
                                run("123", "456", "420"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("number can not contain zero."),
                3, 6, 9
        );
    }

    @DisplayName("게임 도중 사용자의 잘못된 입력으로 예외 발생(중복된 숫자를 입력한 경우)")
    @Test
    void case4() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() ->
                                run("123", "456", "422"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("number can not have duplicated digit."),
                3, 6, 9
        );
    }

    @DisplayName("게임 도중 사용자의 잘못된 입력으로 예외 발생(숫자가 아닌 값 입력)")
    @Test
    void case5() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() ->
                                run("123", "l45"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("Number can not have non-numeric value."),
                3, 6, 9
        );
    }

    @DisplayName("게임 도중 사용자의 잘못된 입력으로 예외 발생(3자리 숫자가 아닌 경우)")
    @Test
    void case6() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() ->
                                run("123", "45", "425", "369", "2"))
                                .isInstanceOf(IllegalArgumentException.class)
                                .hasMessageContaining("digit is invalid."),
                3, 6, 9
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
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("l23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("114"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("104"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
