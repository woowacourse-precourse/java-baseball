package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void should_Success_When_GameRestart() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "1", "589", "2");
                    assertThat(output()).contains("3스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3, 5, 8, 9
        );
    }

    @Test
    void should_PrintResult_When_BallStrike() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("142", "321", "123", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void should_PrintResult_When_OnlyBall() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("312", "345", "315", "123", "2");
                    assertThat(output()).contains("3볼", "1볼", "2볼", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void should_PrintResult_When_OnlyStrike() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("145", "128", "123", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void should_PrintResult_When_ZeroMatchNumber() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("678", "891", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void should_Success_When_ComputerDuplicate() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("3스트라이크", "게임 종료");
                },
                1, 2, 2, 2, 2, 2, 3
        );
    }

    @Test
    void should_ThrowException_When_UserLessThan3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("14"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void should_ThrowException_When_UserMoreThan3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void should_ThrowException_When_UserHaveZero() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void should_ThrowException_When_UserIsDigitFalse() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void should_ThrowException_When_UserDuplicate() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
