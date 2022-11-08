package baseball.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameTest extends NsTest {

    @Test
    void restartInputTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void restartInputTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1a2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        BaseballGame.restart();
    }
}