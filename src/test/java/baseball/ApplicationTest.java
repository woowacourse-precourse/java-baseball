package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
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
    void 입력길이_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력한숫자의범위_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("309"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자외입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("8d6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복숫자입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("332"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void makeComputerBall테스트() {

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
