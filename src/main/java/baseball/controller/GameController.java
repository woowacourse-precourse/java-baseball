package baseball.controller;

import java.util.List;

import baseball.service.GameService;
import baseball.view.View;

public class GameController {
	static final int ball = 1;
	static final int strike = 0;
	static final int nothing = 0;

	public static String createComputerNumber() {
		return GameService.createRandomNumber();
	}
	public static int gameStart(String user, String computer) {
		saveUserNumber(user);

		List<Integer> result = compareNumber(computer, user);

		gameResult(result);

		return result.get(0);
	}

	public static void gameResult(List<Integer> result) {
		boolean isVisited = false;

		if (result.get(ball) != nothing) {
			isVisited = View.printResult(result.get(ball), ball);
		}
		if (result.get(strike) != nothing) {
			if (isVisited)
				View.printText(View.Text.space.print);
			View.printResult(result.get(strike), strike);
		}
		if (result.get(ball) == nothing && result.get(strike) == nothing) {
			View.printText(View.Text.nothing.print);
		}
		View.printText("\n");
	}
	public static void saveUserNumber(String userNumber) {
		GameService.checkException(userNumber);
	}

	public static List<Integer> compareNumber(String computer, String user) {
		return GameService.compareNumber(GameService.convertStringToList(computer),
				GameService.convertStringToList(user));
	}
}
