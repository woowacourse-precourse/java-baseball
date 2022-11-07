package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStatusTest {

    @Test
    void isRestartTest() {
        GameStatus gameStatus = GameStatus.getGameStatus(1);

        assertThat(gameStatus).isEqualTo(GameStatus.RESTART);
    }

    @Test
    void isEndTest() {
        GameStatus gameStatus = GameStatus.getGameStatus(2);

        assertThat(gameStatus).isEqualTo(GameStatus.END);
    }

    @Test
    void isInvalidNumberTest() {
        assertThatThrownBy(() -> GameStatus.getGameStatus(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 숫자는 없는 숫자입니다");
    }
}
