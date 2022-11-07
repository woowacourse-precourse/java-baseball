package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseBallGameServiceTest {

	@Test
	void 정상적으로_재시작하는지_확인() {
		BaseBallGameService baseBallGameService = new BaseBallGameService();
		String userInput = "1";

		assertTrue(baseBallGameService.wantRestart(userInput));
	}

	@Test
	void 예외가_제대로_발생하는지_확인() {
		BaseBallGameService baseBallGameService = new BaseBallGameService();
		String userInput = "dksldi1";
		String userInput2 = "~!";

		assertThrows(IllegalArgumentException.class, () -> baseBallGameService.wantRestart(userInput));
		assertThrows(IllegalArgumentException.class, () -> baseBallGameService.wantRestart(userInput2));
	}

	@Test
	void 정상적으로_종료되는지_확인() {
		BaseBallGameService baseBallGameService = new BaseBallGameService();
		String userInput = "2";

		assertFalse(baseBallGameService.wantRestart(userInput));
	}
}
