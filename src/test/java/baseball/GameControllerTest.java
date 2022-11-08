package baseball;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GameControllerTest {
	GameController gameController = new GameController();
	@Test
	void gameStartTest() {
		gameController.gameStart();
	}// gameStartTest
	
	@Test
	void gameExitTest() {
        assertTrue(gameController.gameExit("2"));
        assertFalse(gameController.gameExit("1"));
	}//gameExitTest
}
