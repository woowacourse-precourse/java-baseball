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
    void Only_스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("124", "238", "865", "137", "185", "935", "135", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void Only_볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("513", "351", "578", "783", "781", "713", "517", "753", "135", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 입력_숫자_길이를_초과한_경우() {
    void 게임_진행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("789", "158", "357", "138", "531", "135", "1", "719", "2");
                    assertThat(output()).contains(
                            "낫싱", "1볼 1스트라이크", "2볼", "2스트라이크", "2볼 1스트라이크", "3스트라이크",
                            "게임 종료");
                },
                1, 3, 5, 7, 1, 9
        );
    }
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
