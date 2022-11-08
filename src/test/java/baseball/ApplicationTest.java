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
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "193", "248", "1", "692", "987", "2");
                    assertThat(output()).contains("2스트라이크", "낫싱", "3스트라이크", "1볼", "3스트라이크", "게임 종료");
                },
                2, 4, 8, 9, 8, 7
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ff"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("233"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 주의사항_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("902", "987", "2");
                    assertThat(output()).contains("1스트라이크", "0은", "3스트라이크", "게임 종료");
                },
                9, 8, 7
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
