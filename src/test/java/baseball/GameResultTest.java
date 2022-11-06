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

    @Test
    @DisplayName("낫싱 상태를 판단하는지 확인한다")
    void isNothingO() {
        GameResult gameResult = new GameResult();
        gameResult.setGameResult(0, 0);
        Assertions.assertThat(gameResult.isNothing()).isEqualTo(true);
    }

    @Test
    @DisplayName("낫싱 상태가 아님을 판단하는지 확인한다")
    void isNothingX() {
        GameResult gameResult = new GameResult();
        gameResult.setGameResult(1, 0);
        Assertions.assertThat(gameResult.isNothing()).isEqualTo(false);
    }
}
