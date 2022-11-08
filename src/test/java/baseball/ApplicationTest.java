package baseball;

import baseball.util.GameExceptionMessage;
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
    void 입력값_일치_후_게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "789", "157", "248", "247", "742", "2");
                    assertThat(output()).contains(
                            "1볼", "1볼", "1스트라이크", "1볼", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                7, 4, 2
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 세자리_미만_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER)
        );
    }

    @Test
    void 중복_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER)
        );
    }

    @Test
    void 범위_밖_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(GameExceptionMessage.ENTER_NUMBER_FROM_ONE_TO_NINE)
        );
    }

    @Test
    void 문자열_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER)
        );
    }

    @Test
    void 공백_문자열_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER)
        );
    }

    @Test
    void 빈문자열_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}