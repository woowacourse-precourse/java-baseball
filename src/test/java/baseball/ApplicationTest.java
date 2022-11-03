package baseball;

import static baseball.BaseballGame.GAME_START_MESSAGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {


    @DisplayName("게임 시작시 게임 시작 문구를 출력한다.")
    @Test
    void case1() {
        assertSimpleTest(() ->
                assertThat(output().startsWith(GAME_START_MESSAGE)));
    }

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

    @DisplayName("입력값이 3자리가 아닐 경우 예외를 반환한다 - 3자리 보다 큰 경우")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력값이 3자리가 아닐시 예외를 반환한다 - 3자리 보다 작은 경우")
    @Test
    void case2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력값이 숫자가 아닌 값을 포함할 경우 예외를 반환한다")
    @Test
    void case3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
