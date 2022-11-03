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
    void 게임종료_후_재시작_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("346", "647", "124", "1", "537", "689", "2");
                    assertThat(output()).contains("1볼", "1볼", "3스트라이크", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 2, 4, 6, 8, 9
        );
    }

    @Test
    void 게임종료_후_재시작_3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "647", "478", "479", "1", "513", "1", "135", "264", "2");
                    assertThat(output()).contains("낫싱", "2볼", "2스트라이크", "3스트라이크", "3스트라이크", "1", "낫싱", "3스트라이크", "게임 종료");
                },
                4, 7, 9, 5, 1, 3, 2, 6, 4
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
    void 중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 글자수_중복_범위_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1330"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
