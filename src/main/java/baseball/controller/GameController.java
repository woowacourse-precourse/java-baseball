package baseball.controller;

import java.util.List;

import baseball.service.ExceptionHandler;
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
		checkErrorNumber(user);

		return gameResult(compareNumber(computer, user));
	}
	public static Integer gameResult(List<Integer> result) {
		boolean isVisited = false;

		if (result.get(ball) != nothing) {
			isVisited = View.printResult(result.get(ball), ball);
		}
		if (result.get(strike) != nothing) {
			View.isSpace(isVisited);
			View.printResult(result.get(strike), strike);
		}
		if (result.get(ball) == nothing && result.get(strike) == nothing) {
			View.printText(View.Text.nothing.print);
		}
		View.printText("\n");

		return result.get(strike);
	}
	public static void checkErrorNumber(String userNumber) {
		ExceptionHandler.checkException(userNumber);
	}
	public static List<Integer> compareNumber(String computer, String user) {
		return GameService.compareNumber(computer, user);
	}
}
