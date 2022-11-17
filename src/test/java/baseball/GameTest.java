package baseball;

import baseball.game.Game;
import baseball.game.utils.ScoreBoard;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 결과로_게임_종료를_결정하는_기능_false() {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.addStrike();
        scoreBoard.addStrike();
        scoreBoard.addStrike();

        Assertions.assertThat(Game.checkGameOver(scoreBoard)).isEqualTo(false);
    }

    @Test
    void 결과로_게임_종료를_결정하는_기능_true() {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.addStrike();
        scoreBoard.addStrike();

        Assertions.assertThat(Game.checkGameOver(scoreBoard)).isEqualTo(true);
    }
}
