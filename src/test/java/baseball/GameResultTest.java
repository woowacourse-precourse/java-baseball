package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {
    @Test
    @DisplayName("사용자가 이겼다고 판단하는지 확인한다")
    void isUserWinTestO() {
        GameResult gameResult = new GameResult();
        gameResult.setGameResult(3, 0);
        Assertions.assertThat(gameResult.isUserWin()).isEqualTo(true);
    }

    @Test
    @DisplayName("사용자가 졌다고 판단하는지 확인한다")
    void isUserWinTestX() {
        GameResult gameResult = new GameResult();
        gameResult.setGameResult(2, 1);
        Assertions.assertThat(gameResult.isUserWin()).isEqualTo(false);
    }
}
