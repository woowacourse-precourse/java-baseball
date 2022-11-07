package baseball.controller;

import java.util.List;

import baseball.dto.BaseballDto;
import baseball.service.BaseballService;
import baseball.utils.Game;
import baseball.utils.Text;
import baseball.view.Output;

public class BaseballController {
	static final int ball = 1;
	static final int strike = 0;

	public static String createComputerNumber() {
		return BaseballService.createRandomNumber();
	}

	public static void startGame() {
		BaseballDto.setComputer();

		do {
			Output.printText(Text.input.getPrint());
			BaseballDto.setUser("user");
		} while (isGameResult(compareNumber()) != 3);    // 결과가 3 스트라이크가 아니면

		Output.printNotice("restart");
	}

	public static void requestPrintf(List<Integer> result) {
		boolean isVisited = false;

		// ball != 0
		if (result.get(ball) != Game.nothing.getValue()) {
			isVisited = Output.printResult(result.get(ball), ball);
		}
		// strike != 0
		if (result.get(strike) != Game.nothing.getValue()) {
			Output.isSpace(isVisited);
			Output.printResult(result.get(strike), strike);
		}
		// ball == 0 && strike == 0
		if ((result.get(ball) == Game.nothing.getValue()) && (result.get(strike) == Game.nothing.getValue())) {
			Output.printText(Text.nothing.getPrint());
		}
		Output.printText("\n");
	}

	public static Integer isGameResult(List<Integer> result) {
		requestPrintf(result);

		return result.get(strike);
	}

	public static List<Integer> compareNumber() {
		return BaseballService.compareNumber();
	}

	public static void restartGame() {
		Output.printNotice("start");

		do {
			startGame();
			BaseballDto.setUser("restart");
		} while (BaseballDto.getUser().equals("1"));    // 1일 경우 재시작
	}
}
