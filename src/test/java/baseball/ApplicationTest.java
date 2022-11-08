package baseball;

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
    void 스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "267", "239", "168", "169", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 6, 9
        );
    }

    @Test
    void 볼() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("623", "612", "169", "1", "423", "234", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼", "게임 종료");
                },
                1, 6, 9, 2, 3, 4
        );
    }

    @Test
    void 낫싱() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("248", "169", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 6, 9
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
    void 예외_테스트2() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> runException("169", "a")).isInstanceOf((IllegalArgumentException.class)),
                1, 6, 9
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
