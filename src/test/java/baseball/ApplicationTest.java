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
    void 숫자가_아닌_문자를_입력_예외발생() {
        assertThatThrownBy(() -> runException("7*3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력_길이가_3보다_큼_예외발생() {
        assertThatThrownBy(() -> runException("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력_길이가_3보다_작음_예외발생() {
        assertThatThrownBy(() -> runException("19"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력에_0이_포함_예외발생() {
        assertThatThrownBy(() -> runException("108"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력에_중복이_포함_예외발생() {
        assertThatThrownBy(() -> runException("556"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "2");
                    assertThat(output()).contains("3스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("136", "135", "2");
                    assertThat(output()).contains("2스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("146", "135", "2");
                    assertThat(output()).contains("1스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크1_볼2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("153", "135", "2");
                    assertThat(output()).contains("2볼 1스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크1_볼1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("156", "135", "2");
                    assertThat(output()).contains("1볼 1스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 볼3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("513", "135", "2");
                    assertThat(output()).contains("3볼");
                },
                1, 3, 5
        );
    }

    @Test
    void 볼2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("514", "135", "2");
                    assertThat(output()).contains("2볼");
                },
                1, 3, 5
        );
    }

    @Test
    void 볼1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("589", "135", "2");
                    assertThat(output()).contains("1볼");
                },
                1, 3, 5
        );
    }

    @Test
    void 낫싱() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5
        );
    }

    @Test
    void 게임종료_후_최종종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("게임이 종료되었습니다.");
                },
                1, 3, 5
        );
    }

    @Test
    void 재시작_옵션_잘못_입력_예외발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "567", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                5, 6, 7
        );
    }

    @Test
    void 재시작_옵션_1을_입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "567", "2");
                    assertThat(output()).contains("숫자를 입력해주세요", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                },
                1, 3, 5, 5, 6, 7
        );
    }

    @Test
    void 재시작_옵션_2를_입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatCode(() -> runException("246", "567", "2"))
                            .doesNotThrowAnyException();
                },
                5, 6, 7
        );
    }
}
