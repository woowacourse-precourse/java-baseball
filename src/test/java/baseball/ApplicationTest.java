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
    void 입력_글자_수_예외_테스트() {
        // 4글자
        assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class);

        // 2글자
        assertThatThrownBy(() -> runException("12"))
                .isInstanceOf(IllegalArgumentException.class);

        // 1글자
        assertThatThrownBy(() -> runException("1"))
                .isInstanceOf(IllegalArgumentException.class);

        // Enter
        assertThatThrownBy(() -> runException("\n"))
                .isInstanceOf(IllegalArgumentException.class);

        // null
        assertThatThrownBy(() -> runException(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void 입력_문자열_숫자_예외_테스트() {
        // 같은 숫자가 중복으로 입력되는 경우
        assertThatThrownBy(() -> Application.generateUserNumber("112"))
                .isInstanceOf(IllegalArgumentException.class);

        // 0이 들어간 모두 다른 3자리 숫자의 경우
        assertThatThrownBy(() -> runException("094"))
                .isInstanceOf(IllegalArgumentException.class);

        // 한 글자만 숫자가 아닌 경우
        assertThatThrownBy(() -> runException("1-2"))
                .isInstanceOf(IllegalArgumentException.class);

        // 숫자가 아닌 값이 들어가는 경우
        assertThatThrownBy(() -> runException("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
