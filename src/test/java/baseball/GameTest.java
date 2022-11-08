package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    private Game game;
    @BeforeEach
    void 게임_생성() {
        game = new Game();
    }
    @Test
    void 종료조건_재시작_입력() {
        game.setInput("1");
        assertTrue(game.inputArrList.contains(game.input));
    }
    @Test
    void 예외_종료조건_비정상_숫자_입력() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.setInput("3");
        });
    }
    @Test
    void 예외_종료조건_비정상_문자_입력() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.setInput("a");
        });
    }
}