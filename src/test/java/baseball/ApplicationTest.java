package baseball;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 입력한_숫자_결과판단_테스트_및_재시작_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "567", "159", "561", "153", "513", "189", "139", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "1볼", "1볼 1스트라이크", "2볼", "2볼 1스트라이크", "3볼", "1스트라이크", "2스트라이크", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }
    @Test
    void 예외_테스트_사용자_숫자_입력_3자리_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_사용자_숫자_입력_2자리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_사용자_숫자_입력_1자리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_사용자_숫자_입력_0포함입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_사용자_숫자_입력_대신_숫자아닌입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("테스트"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_사용자_숫자_입력_공백포함입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_사용자_숫자_입력_중복숫자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
