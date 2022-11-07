package baseball;

import baseball.model.Constant;
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
    void 숫자가_아닌_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1s5"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 양끝_중복숫자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 모두_중복숫자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("888"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 범위밖의_숫자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("206"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 재시작없이_게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "513", "158", "185", "135", "2");
                    assertThat(output()).contains("낫싱", "3볼", "1볼 1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 재시작_문자열_입력_테스트() {
        assertThatThrownBy(() -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "a");
                    },
                    1, 3, 5
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.END_INPUT_NOT_NUMBER);
        ;
    }

    @Test
    void 재시작_다른숫자_입력_테스트() {
        assertThatThrownBy(() -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "5");
                    },
                    1, 3, 5
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.END_INPUT_INVALID_END_TYPE);
        ;
    }

    @Test
    void 재시작_두자리_숫자_입력_테스트() {
        assertThatThrownBy(() -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "12");
                    },
                    1, 3, 5
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constant.END_INPUT_INVALID_NUMBER_SIZE);
        ;
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
