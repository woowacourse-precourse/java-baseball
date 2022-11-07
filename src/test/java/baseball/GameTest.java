package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class GameTest {
    Scanner scanner = new Scanner(System.in);
    Game game = new Game(scanner);

    @Test
    @DisplayName("사용자가 게임 재시작을 원할 경우")
    void case1() {
        String playerInput = "1";
        game.isGameRestart(playerInput);
        boolean result = game.getGameStatus();
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("사용자가 게임을 종료할 경우")
    void case2() {
        String playerInput = "2";
        game.isGameRestart(playerInput);
        boolean result = game.getGameStatus();
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("사용자가 1, 2 이외의 수를 입력한 경우")
    void case3() {
        String playerInput = "3";
        assertThatThrownBy(() -> game.isGameRestart(playerInput))
                .isInstanceOf(InputMismatchException.class)
                .hasMessageContaining("1과 2중 하나만 입력하세요");
    }

    @Test
    @DisplayName("사용자가 1, 2 이외의 문자를 입력한 경우")
    void case4() {
        String playerInput = "시작";
        game.isGameRestart(playerInput);
        boolean result = game.getGameStatus();
        assertThatThrownBy(() -> game.isGameRestart(playerInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("1과 2중 하나만 입력하세요");
    }
}
