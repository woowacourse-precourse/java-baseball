package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;

    @BeforeEach
    void createGame() {
        game = new Game();
    }
    @Test
    void isInputNumber1Or2() {
        game.setInput("1");
        assertTrue(game.inputArrList.contains(game.input));

    }
    @Test
    void isInputNumberNot1Nor2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.setInput("3");
        });
    }


}