package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameManagerTest {

    GameManager gameManager = new GameManager();

    @Test
    void 게임_새로_시작() {
        Assertions.assertThat(gameManager.isGameContinue(1)).isTrue();
    }

    @Test
    void 게임_종료() {
        Assertions.assertThat(gameManager.isGameContinue(2)).isFalse();
    }

    @Test
    void canGameContinue_예외입력() {
        Assertions.assertThatThrownBy(() -> gameManager.isGameContinue(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}