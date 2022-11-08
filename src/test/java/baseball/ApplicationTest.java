package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작_1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임종료_후_재시작_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("124", "215", "123", "1", "789", "457", "456", "1", "793", "789", "2");
                    assertThat(output()).contains("2스트라이크", "2볼", "3스트라이크", "낫싱", "2스트라이크", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3, 4, 5, 6, 7, 8, 9
        );
    }


    @Test
    void 예외_테스트_입력값이_범위밖의_정수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력값이_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력값이_같은_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_입력값이_문자열과_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ab321cd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_입력값이_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_입력값이_공백과_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_입력값이_공백과_문지() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
