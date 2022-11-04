package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ExceptionTest extends NsTest {

    @Test
    @DisplayName("예외 테스트: 길이 테스트")
    void case1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 0 포함 여부 테스트")
    void case2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("120"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 정수 여부 테스트")
    void case3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("문자열"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 중복 여부 테스트")
    void case4() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("122"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 게임 종료 후 1 또는 2 입력 여부 테스트")
    void case5() {
        assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "0");
                assertThat(output()).contains("낫싱", "3스트라이크", "잘못된 값");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("예외 테스트: 게임 종료 후 1 또는 2 입력 여부 테스트")
    void case6() {
        assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "문자열");
                assertThat(output()).contains("낫싱", "3스트라이크", "잘못된 값");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}