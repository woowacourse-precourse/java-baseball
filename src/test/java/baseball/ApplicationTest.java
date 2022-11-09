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

    @Test
    void 입력_숫자_길이를_초과한_경우_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복된_숫자_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("558"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_범위_입력값_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void null_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException((String) null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_알파벳_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_공백_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3 5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 재시작_여부_잘못된_입력_예외테스트() {
        assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                () -> {
                    run("135", "3");
                },
                1, 3, 5, 5, 8, 9
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
