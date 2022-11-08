package baseball.service;

import baseball.domain.BaseBallGame;
import baseball.domain.GameResult;

public class BaseBallGameService {
	private static final String RESTART_NUMBER = "1";
	private static final String END_NUMBER = "2";
	private BaseBallGame baseBallGame;

	public void initBaseBallGame() {
		this.baseBallGame = new BaseBallGame();
	}

	public GameResult compareTwoNumber(String userInput) {
		baseBallGame.inputUserNumber(userInput);
		baseBallGame.countScore();
		return baseBallGame.getGameResult();
	}

	public boolean wantRestart(String userInput) throws IllegalArgumentException {
		if (!isValidInput(userInput)) {
			throw new IllegalArgumentException();
		}
		return userInput.equals(RESTART_NUMBER);
	}

	private boolean isValidInput(String input) {
		return input.equals(RESTART_NUMBER) || input.equals(END_NUMBER);
	}
}
