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
    void 예외_테스트_중복된_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복된 숫자가 포함되어 있습니다.")
        );
    }

    @Test
    void 예외_테스트_0_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("허용되지 않은 문자가 포함되어 있습니다.")
        );
    }

    @Test
    void 예외_테스트_문자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12L"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("허용되지 않은 문자가 포함되어 있습니다.")
        );
    }

    @Test
    void 예외_테스트_길이_3미만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값이 3자리가 아닙니다.")
        );
    }

    @Test
    void 게임실행_낫싱_1볼_1볼1스트라이크_2볼_2볼1스트라이크_3볼_1스트라이크_2스트라이크_3스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "416", "413", "412", "132", "312", "156", "126", "123", "2");
                    assertThat(output()).contains("낫싱", "1볼", "1볼 1스트라이크", "2볼", "2볼 1스트라이크", "3볼",
                            "1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
