package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static constant.ErrorMessage.*;
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
    void 게임종료_후_재시작_깃헙예시() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "145", "671", "216", "713", "1", "123", "452", "2");
                    assertThat(output())
                            .contains("1볼 1스트라이크", "1볼", "2볼", "1스트라이크", "3스트라이크", "게임 종료", "1볼");
                },
                7, 1, 3, 4, 5, 2
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_INPUT_RADIX)
        );
    }

    @Test
    void 입력값_테스트_비정상입력_길이초과() {
        assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_INPUT_RADIX);

    }

    @Test
    void 입력값_테스트_비정상입력_길이미달() {
        assertThatThrownBy(() -> runException("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_INPUT_RADIX);
    }

    @Test
    void 입력값_테스트_비정상입력_문자포함() {
        assertThatThrownBy(() -> runException("12c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_INPUT_VALUE);
    }

    @Test
    void 입력값_테스트_비정상입력_같은숫자포함() {
        assertThatThrownBy(() -> runException("224"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_INPUT_VALUE);
    }

    @Test
    void 입력값_테스트_비정상입력_범위벗어난_숫자() {
        assertThatThrownBy(() -> runException("102"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_INPUT_VALUE);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
