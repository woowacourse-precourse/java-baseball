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
    void exception_test1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_test2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("131"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void exception_test3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void runTest1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "124", "789", "321", "123", "2");
                    assertThat(output()).contains("낫싱", "2스트라이크", "낫싱", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}