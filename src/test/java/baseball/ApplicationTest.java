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
    void 예외_테스트_4자리숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("3자리가 아닙니다.")
        );
    }

    @Test
    void 예외_테스트_4자리문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a cd"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("3자리가 아닙니다.")
        );
    }

    @Test
    void 예외_테스트_3자리문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sdf"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1과 9 사이 정수를 제외한 다른 문자가 들어있습니다.")
        );
    }

    @Test
    void 예외_테스트_2자리문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("l;"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("3자리가 아닙니다.")
        );
    }

    @Test
    void 예외_테스트_2자리숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("56"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("3자리가 아닙니다.")
        );
    }


    @Test
    void 예외_테스트_중복된숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자를 중복하여 입력하셨습니다.")
        );
    }

    @Test
    void 예외_테스트_0포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("806"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1과 9 사이 정수를 제외한 다른 문자가 들어있습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
