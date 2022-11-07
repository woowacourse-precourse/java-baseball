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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_영문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_한글() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("홍길동"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_공백이_포함된_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1 23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_네자리_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1423"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_한자리_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0이_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_마이너스_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_정수가_아닌_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0.12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
