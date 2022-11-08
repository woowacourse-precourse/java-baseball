package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @DisplayName("게임이 재시작 되는 경우")
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

    @DisplayName("사용자가 입력한 숫자가 3자리가 아닌 경우")
    @Test
    void 입력_예외_테스트_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("사용자가 입력한 값에 숫자가 아닌 문자가 포함된 경우")
    @Test
    void 입력_예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("가12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("사용자가 입력한 값에 중복된 숫자가 있는 경우")
    @Test
    void 입력_예외_테스트_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("게임 재시작 여부 입력에 1과 가 아닌 다른 값이 들어간 경우")
    @Test
    void 입력_예외_테스트_4() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("135","a"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
