package baseball.domain;

import java.util.List;

public class BaseBallGame {
	private final List<Integer> computerNumber;
	private List<Integer> userNumber;
	private GameResult gameResult;

	public BaseBallGame() {
		this.computerNumber = new ComputerNumber().getComputerNumber();
	}

	public void inputUserNumber(String str) {
		this.userNumber = new UserNumber(str).getUserNumber();
	}

	public void countScore() {
		this.gameResult = new GameResult(computerNumber, userNumber);
	}

	public GameResult getGameResult() {
		return gameResult;
	}
}
