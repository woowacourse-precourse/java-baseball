package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
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
    void 다양한_경우의_볼_스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("618", "675", "163", "315", "138", "135", "2");
                    assertThat(output()).contains("1볼", "1스트라이크", "1볼 1스트라이크",
                            "2볼 1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_숫자야구게임중_잘못된_범위의_입력값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_숫자야구게임중_중복된_입력값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("333"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_숫자야구게임중_숫자가아닌_입력값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("뮤"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_게임종료_선택지중_잘못된_범위의_입력값_1() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                assertRandomNumberInRangeTest(
                        () -> run("135", "3"),
                        1, 3, 5
                ));

    }

    @Test
    void 예외_게임종료_선택지중_잘못된_범위의_입력값_2() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                assertRandomNumberInRangeTest(
                        () -> run("135", "321"),
                        1, 3, 5
                ));
    }

    @Test
    void 예외_게임종료_선택지중_숫자가아닌_입력값() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                assertRandomNumberInRangeTest(
                        () -> run("135", "뮤"),
                        1, 3, 5
                ));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
