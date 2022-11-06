package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
	private final List<Integer> computerNumber;
	private List<Integer> userNumber;
	private GameResult gameResult;

	public BaseBallGame() {
		this.computerNumber = new ComputerNumber().computerNumber;
	}

	private void inputUserNumber(String str) {
		this.userNumber = new UserNumber(str).userNumber;
	}

	private void countScore() {
		this.gameResult = new GameResult(computerNumber, userNumber);
	}

	public List<Integer> getComputerNumber() {
		return computerNumber;
	}

	public GameResult getGameResult() {
		return gameResult;
	}

	public List<Integer> getUserNumber() {
		return userNumber;
	}
}
