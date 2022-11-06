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
    void computer123_user456and789and123and2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "789", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void computer123_user231and123and2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("231", "123", "2");
                    assertThat(output()).contains("3볼", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Test
    void computer123_userA12_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("A12"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^A12$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user12A_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("12A"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^12A$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user한12_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("한12"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^한12$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user12한_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("12한"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^12한$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run(""))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user1_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^1$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user11_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("11"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^11$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user12_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("12"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^12$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user122_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("122"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^122$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user120_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("120"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^120$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user121_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("121"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^121$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user1234_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^1234$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user0_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("0"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^0$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user3_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^3$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user_1_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("-1"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^-1$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_userA_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("A"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^A$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user한_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("한"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^한$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user123and3_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("123", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^3$");
                }, 1, 2, 3
        );
    }

    @Test
    void computer123_user123andA_exception() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("123", "A"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("Your input string is mismatch: ^A$");
                }, 1, 2, 3
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
}
