package baseball.controller;

import java.util.List;

import baseball.service.GameService;

public class GameController {
	final int min = 1;
	final int max = 9;
	GameService gameService = new GameService();

	public String gameStart() {
		return gameService.createRandomNumber();
	}

	public void saveUserNumber(String userNumber) {
		gameService.checkException(userNumber);
	}

	public List<Integer> compareNumber(String computer, String user) {
		List<Integer> result = gameService.compareNumber(gameService.convertStringToList(computer),
				gameService.convertStringToList(user));

		return result;
	}
}
