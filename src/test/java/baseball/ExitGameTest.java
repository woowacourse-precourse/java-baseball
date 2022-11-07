package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ExitGameTest extends NsTest {

    @Test
    void exitGame() {
    }

    private boolean result;

    @Test
    void 게임_새로시작() {
        run("1");
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 게임_종료() {
        run("2");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 게임_새로시작_잘못된_값_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        ExitGame exitGame = new ExitGame();
        result = exitGame.exitGame();
    }
}