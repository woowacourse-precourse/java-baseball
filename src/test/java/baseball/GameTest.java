package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void returnStrike() {
        Game game = new Game();
        assertEquals(1, game.strike("135", "123"));
    }

}