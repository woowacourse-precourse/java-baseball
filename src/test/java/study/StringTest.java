package study;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class StringTest extends NsTest {

    @Test
    void 예외_테스트_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("830"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("80"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임종료후_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "135", "4"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1,3,5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
