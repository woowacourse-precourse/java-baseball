package baseball.runner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.engine.BaseballEngine;
import baseball.engine.PlayState;
import baseball.viewer.BaseballViewer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class BaseballRunnerTest extends NsTest {


    @Override
    protected void runMain() {
        BaseballEngine engine = new BaseballEngine();
        BaseballViewer viewer = new BaseballViewer();
        IGameRunner runner = new BaseballRunner(viewer, engine);
        runner.init();

        while (runner.run() == PlayState.RUN) {

        }

    }

    @Test
    void 낫싱_테스트_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "123", "2");
                    assertThat(output()).contains("낫싱");
                },
                7, 8, 9
        );
    }

    @Test
    void 볼_테스트_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("172", "871", "978", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼");
                },
                7, 8, 9
        );
    }

    @Test
    void 스트라이크_테스트_후_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("712", "782", "789", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                7, 8, 9
        );
    }

    @Test
    void 중복되는_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 길이가_초과된_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백이_포함된_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 24"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위_외의_숫자가_포함된_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("024"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 종합_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "123", "1", "712", "781", "983", "1", "247", "123", "456", "2");
                    assertThat(output()).contains("낫싱", "1볼", "2스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                7, 8, 9, 7, 8, 9, 4, 5, 6
        );
    }


}