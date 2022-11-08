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
    void 게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "143", "438", "2");
                    assertThat(output()).contains("1볼", "2볼", "3스트라이크", "게임 종료");
                },
                4,3,8
        );
    }
    @Test
    void 입력값_내_중복_발생() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("111", "222", "333", "133", "122", "132", "2");
                    assertThat(output()).contains("2볼 1스트라이크", "2볼 1스트라이크", "2볼 1스트라이크", "1볼 2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 2
        );
    }

    @Test
    void 예외_0_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_0이_포함된_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("301"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_글자수_초과_테스트() {
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
