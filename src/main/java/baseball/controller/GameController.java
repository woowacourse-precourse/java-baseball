package baseball.controller;

import java.util.List;

import baseball.service.GameService;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
	final int min = 1;
	final int max = 9;
	GameService gameService = new GameService();
	View view = new View();

	public String createRandom() {
		String computer = gameService.createRandomNumber();

		return computer;
	}
	public int gameStart(String user, String computer) {
		boolean isVisited = false;

		saveUserNumber(user);

		List<Integer> result = compareNumber(computer, user);
		if (result.get(1) != 0) {
			if (isVisited)
				System.out.print(" ");
			view.printResult(result.get(1), 2);
		}
		if (result.get(0) != 0) {
			if (isVisited)
				System.out.print(" ");
			view.printResult(result.get(0), 1);
			isVisited = true;
		}
		if (result.get(0) == 0 && result.get(0) == 0) {
			if (isVisited)
				System.out.print(" ");
			view.printResult(0,3);
		}

		return result.get(0);
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
