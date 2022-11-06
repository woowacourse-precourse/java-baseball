package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GameTest {
    Game game = new Game();

    @Test
    @DisplayName("사용자가 게임 재시작을 원할 경우")
    void case1() {
        String playerInput = "1";
        boolean result = game.isValidInput(playerInput);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("사용자가 게임을 종료할 경우")
    void case2() {
        String playerInput = "2";
        boolean result = game.isValidInput(playerInput);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("사용자가 1, 2 이외의 값을 입력한 경우")
    void case3() {
        String playerInput = "시작";
        boolean result = game.isValidInput(playerInput);
        assertThatThrownBy(() -> game.isValidInput(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("재시작을 원하면 1, 종료를 원하면 2를 입력하세요");
    }
}
