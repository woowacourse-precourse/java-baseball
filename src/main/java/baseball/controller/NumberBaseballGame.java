package baseball.controller;

import baseball.controller.dto.UserInputPlayNumbers;
import baseball.controller.dto.UserInputRestartCode;
import baseball.model.gameresult.GameResult;
import baseball.model.numberbaseball.NumberBaseball;
import baseball.model.numberbaseball.application.NumberBaseballService;
import baseball.model.restartcode.RestartStatus;
import baseball.view.NumberBaseballView;

public class NumberBaseballGame {
	private final NumberBaseballView numberBaseballView;
	private final NumberBaseballService numberBaseballService;

	public NumberBaseballGame(NumberBaseballView numberBaseballView,
		NumberBaseballService numberBaseballService) {
		this.numberBaseballView = numberBaseballView;
		this.numberBaseballService = numberBaseballService;
	}

	public void initGame() {
		numberBaseballView.initPage();
	}

	public void playBall() {
		NumberBaseball computerNumber = getComputerNumberBaseball();

		GameResult gameResult;
		do {
			NumberBaseball userNumber = getUserInputPlayNumbers();
			gameResult = numberBaseballService.compareNumberBaseBall(computerNumber, userNumber);
			numberBaseballView.resultPage(gameResult);
		} while (!gameResult.isEndCondition());

		numberBaseballView.endPage();
	}

	public boolean restart() {
		RestartStatus userInputRestartCode = getUserInputRestartCode();
		if (userInputRestartCode == RestartStatus.RESTART) {
			return true;
		}

		return false;
	}

	private NumberBaseball getComputerNumberBaseball() {
		return numberBaseballService.createNumberBaseball();
	}

	private NumberBaseball getUserInputPlayNumbers() {
		UserInputPlayNumbers userInputPlayNumbers = numberBaseballView.playPage();
		return userInputPlayNumbers.toNumberBaseball();
	}

	private RestartStatus getUserInputRestartCode() {
		UserInputRestartCode userInputRestartCode = numberBaseballView.restartPage();
		return userInputRestartCode.toRestartCode();
	}

}
