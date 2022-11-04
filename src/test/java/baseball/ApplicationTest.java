package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void countBallTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("697");
                    assertThat(output()).contains("1볼");
                },
                5, 8, 9
        );
    }

    @Test
    void countStrikeTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("519");
                    assertThat(output()).contains("2스트라이크");
                },
                5, 8, 9
        );
    }

    @Test
    void countBall_StrikeTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("597");
                    assertThat(output()).contains("1볼 1스트라이크");
                },
                5, 8, 9
        );
    }

    @Test
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123");
                    assertThat(output()).contains("낫싱");
                },
                5, 8, 9
        );
    }

    @Test
    void ThreeStrike() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("589");
                    assertThat(output()).contains("3스트라이크\n" +
                            "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                },
                5, 8, 9
        );
    }
}
