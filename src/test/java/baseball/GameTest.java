package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void returnStrikeAndBall() {
        Game game = new Game();
        assertEquals("1볼 1스트라이크", game.strikeAndBall("589", "597"));
    }

}