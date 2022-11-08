package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
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
                run("145", "124", "123",
                    "1", "416", "156", "451", "456","2");
                assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크",
                            "2스트라이크", "2스트라이크", "2스트라이크");
            },
            1, 2, 3,
            4, 5, 6
        );
    }

    @Test
    void 볼() {
        assertRandomNumberInRangeTest(
            () -> {
                run("345", "234", "312", "123", "2");
                assertThat(output()).contains("1볼", "2볼", "3볼", "3스트라이크", "게임 종료");
            },
            1, 2, 3
        );
    }

    @Test
    void 낫싱() {
        assertRandomNumberInRangeTest(
            () -> {
                run("456", "789", "123", "2");
                assertThat(output()).contains("낫싱", "낫싱", "3스트라이크", "게임 종료");
            },
            1, 2, 3
        );
    }

    @Test
    void 예외_테스트_3자리_이상_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0입력() {
        assertRandomNumberInRangeTest(
            () -> assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf((IllegalArgumentException.class)),
            1, 6, 9
        );
    }

    @Test
    void 예외_테스트_문자_입력() {
        assertRandomNumberInRangeTest(
            () -> assertThatThrownBy(() -> runException("12b"))
                .isInstanceOf((IllegalArgumentException.class)),
            1, 6, 9
        );
    }

    @Test
    void 예외_테스트_중복_입력() {
        assertRandomNumberInRangeTest(
            () -> assertThatThrownBy(() -> runException("112"))
                .isInstanceOf((IllegalArgumentException.class)),
            1, 6, 9
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
