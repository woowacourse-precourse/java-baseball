package baseball.controller;

import java.util.List;

import baseball.Text;
import baseball.service.ExceptionHandler;
import baseball.service.GameService;
import baseball.view.output;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
	static final int ball = 1;
	static final int strike = 0;
	static final int nothing = 0;

	public static String createComputerNumber() {
		return GameService.createRandomNumber();
	}
	public static void gameStart() {
		String user;
		String computer = createComputerNumber();

		do {
			output.printText(Text.input.getPrint());
			user = Console.readLine();
			checkErrorNumber(user);
		} while (gameResult(compareNumber(computer, user)) != 3);

		printNotice("reStart");
	}
	public static void reStart() {
		printNotice("start");

		do {
			gameStart();
		}while (Console.readLine().equals("1"));
	}
	public static Integer gameResult(List<Integer> result) {
		boolean isVisited = false;

		if (result.get(ball) != nothing) {
			isVisited = output.printResult(result.get(ball), ball);
		}
		if (result.get(strike) != nothing) {
			output.isSpace(isVisited);
			output.printResult(result.get(strike), strike);
		}
		if (result.get(ball) == nothing && result.get(strike) == nothing) {
			output.printText(Text.nothing.getPrint());
		}
		output.printText("\n");

		return result.get(strike);
	}
	public static void checkErrorNumber(String userNumber) {
		ExceptionHandler.checkException(userNumber);
	}
	public static List<Integer> compareNumber(String computer, String user) {
		return GameService.compareNumber(computer, user);
	}
	public static void printNotice(String type) {
		if (type.equals("reStart")) {
			output.printText(Text.stop.getPrint());
			output.printText(Text.choice.getPrint());
		}
		if (type.equals("start")) {
			output.printText(Text.start.getPrint());
		}
	}
}
