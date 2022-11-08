package baseball;

import baseball.gameComponents.GameComponent;
import baseball.gameComponents.GameManager;
import baseball.gameComponents.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameMangerTest extends NsTest {

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("034"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 성공_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "219", "137", "153", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼", "2스트라이크", "2볼 1스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Validator validator = new Validator();
        GameComponent gameComponent = new GameComponent(validator);
        GameManager gameManager = new GameManager(gameComponent, validator);
        gameManager.gameStart();
    }
}
