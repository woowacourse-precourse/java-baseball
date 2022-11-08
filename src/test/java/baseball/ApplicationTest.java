package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 스크라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("512", "182", "129", "581", "519", "189", "589", "2");
                    assertThat(output()).contains("1스트라이크", "1스트라이크", "1스트라이크", "2스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                5, 8, 9
        );
    }

    @Test
    void 볼() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("125", "152", "812", "128", "912", "192", "851", "185", "158", "958", "895", "589", "2");
                    assertThat(output()).contains("1볼", "1볼", "1볼", "1볼", "1볼", "1볼", "2볼", "2볼", "2볼", "3볼", "3볼", "3스트라이크", "게임 종료");
                },
                5, 8, 9
        );
    }

    @Test
    void 에러_문자() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "A"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 에러_길이_초과() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "12"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 에러_예외_문자() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트_길이_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_길이_미달() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_허용_범위_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력_값_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_입력_값_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 중복_값이_아닌_경우() {
        assertThat(Validate.validateSameNumber("123")).isEqualTo(true);
    }

    @Test
    void 중복_값인_경우() {
        assertThat(Validate.validateSameNumber("112")).isEqualTo(false);
    }

    @Test
    void 길이가_같은_경우() {
        assertThat(Validate.validateCountNumber("123", 3)).isEqualTo(true);
    }

    @Test
    void 길이가_긴_경우() {
        assertThat(Validate.validateCountNumber("1234", 3)).isEqualTo(false);
    }

    @Test
    void 길이가_짧은_경우() {
        assertThat(Validate.validateCountNumber("12", 3)).isEqualTo(false);
    }

    @Test
    void 유효값인_경우() {
        assertThat(Validate.validateRangeNumber("123", 1, 9)).isEqualTo(true);
    }

    @Test
    void 유효값이_아닌_경우_범위_밖() {
        assertThat(Validate.validateRangeNumber("012", 1, 9)).isEqualTo(false);
    }

    @Test
    void 유효값이_아닌_경우_문자_1() {
        assertThat(Validate.validateCountNumber("a12", 2)).isEqualTo(false);
    }

    @Test
    void 유효값이_아닌_경우_문자_2() {
        assertThat(Validate.validateCountNumber("12 ", 2)).isEqualTo(false);
    }
}
