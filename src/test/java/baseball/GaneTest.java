package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GaneTest extends NsTest {
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
    void Exception_TestOverInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123445612345"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_TestDuplicateInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_TestDuplicateInput2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("991"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_TestDuplicateInput3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("262"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_TestNotRangeInput1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("078"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_TestNotRangeInput2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("840"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Exception_TestNotRangeInput3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("+-/"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
