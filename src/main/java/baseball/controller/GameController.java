package baseball.controller;

import java.util.List;

import baseball.utils.Game;
import baseball.utils.Text;
import baseball.dto.BaseballDto;
import baseball.service.GameService;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
	static final int ball = 1;
	static final int strike = 0;
	public static String createComputerNumber() {
		return GameService.createRandomNumber();
	}
	public static void gameStart() {
		BaseballDto.setComputer();

		do {
			Output.printText(Text.input.getPrint());
			BaseballDto.setUser();
		} while (gameResult(compareNumber()) != 3);

		Output.printNotice("reStart");
	}
	public static void reStart() {
		Output.printNotice("start");

		do {
			gameStart();
		}while (Console.readLine().equals("1"));
	}
	public static Integer gameResult(List<Integer> result) {
		boolean isVisited = false;

		if (result.get(ball) != Game.nothing.getDef()) {
			isVisited = Output.printResult(result.get(ball), ball);
		}
		if (result.get(strike) != Game.nothing.getDef()) {
			Output.isSpace(isVisited);
			Output.printResult(result.get(strike), strike);
		}
		if (result.get(ball) == Game.nothing.getDef() && result.get(strike) == Game.nothing.getDef()) {
			Output.printText(Text.nothing.getPrint());
		}
		Output.printText("\n");

		return result.get(strike);
	}
	public static List<Integer> compareNumber() {
		return GameService.compareNumber();
	}
}
