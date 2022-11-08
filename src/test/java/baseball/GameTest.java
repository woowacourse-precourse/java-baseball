package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GameTest extends NsTest {
    Game game = new Game();

    @Test
    void 게임을_초기_세팅한다() {
        game.setInitialSetting();

        assertThat(game.computer).isInstanceOf(Computer.class);
        assertThat(game.player).isInstanceOf(Player.class);
    }

    @Test
    void 게임을_실행한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "721", "427", "127", "1", "597", "321", "489", "2");
                    assertThat(output()).contains("1볼", "1볼", "2볼 1스트라이크", "3스트라이크", "1볼", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 2, 7, 4, 8, 9
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}