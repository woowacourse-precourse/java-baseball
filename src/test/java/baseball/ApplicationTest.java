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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 개인_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("741", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                7, 4, 1
        );
    }
    @Test
    void 개인_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("682", "1", "452", "712", "892", "982", "1","156", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료", "1스트라이크", "1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료", "3스트라이크", "게임 종료");
                },
                6, 8, 2, 9, 8, 2, 1, 5, 6
        );
    }
    @Test
    void 개인_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("741", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                7, 4, 1
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 개인_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("14"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
