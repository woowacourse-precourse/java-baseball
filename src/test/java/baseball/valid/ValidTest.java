package baseball.valid;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidTest extends NsTest {

    @DisplayName("예외: 숫자 범위를 벗어남")
    @Test
    void 숫자의_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("예외: 숫자가 아닌값")
    @Test
    void 숫자가_아닌값_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("예외: 숫자가 중복된 값")
    @Test
    void 중복된값_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("예외: 재시작 입력값 범위 벗어남")
    @Test
    void 재시작_입력값_범위_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @DisplayName("예외: 재시작 입력값 정수 아님")
    @Test
    void 재시작_입력값_정수아닌값_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "a"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
