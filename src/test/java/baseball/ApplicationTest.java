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
    void 입력받은문자열의길이가_잘못된케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(
                        () -> runException("123456789"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력에중복된숫자가_들어있는케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(
                        () -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력이모두숫자지만_0이들어있는케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(
                        () -> runException("010"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력에_숫자가아닌문자열이_들어오는케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(
                        () -> runException("A11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력으로_공백이들어오는케이스() {
        assertSimpleTest(() ->
                assertThatThrownBy(
                        () -> runException(" 11"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
