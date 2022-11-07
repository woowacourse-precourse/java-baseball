package baseball.controller;

import java.util.List;

import baseball.utils.Game;
import baseball.utils.Text;
import baseball.dto.BaseballDto;
import baseball.service.GameService;
import baseball.view.Output;

public class GameController {
	static final int ball = 1;
	static final int strike = 0;
	public static String createComputerNumber() {
		return GameService.createRandomNumber();
	}
	public static void startGame() {
		BaseballDto.setComputer();

		do {
			Output.printText(Text.input.getPrint());
			BaseballDto.setUser("user");
		} while (gameResult(compareNumber()) != 3);	//결과가 3 스트라이크가 아니면

		Output.printNotice("restart");
	}
	//비교한 결과에 대한 출력을 요청하는 함수
	public static void requestPrintf(List<Integer> result) {
		boolean isVisited = false;

		//ball != 0
		if (result.get(ball) != Game.nothing.getResult()) {
			isVisited = Output.printResult(result.get(ball), ball);
		}
		//strike != 0
		if (result.get(strike) != Game.nothing.getResult()) {
			Output.isSpace(isVisited);
			Output.printResult(result.get(strike), strike);
		}
		//ball == 0 && strike == 0
		if ((result.get(ball) == Game.nothing.getResult()) && (result.get(strike) == Game.nothing.getResult())) {
			Output.printText(Text.nothing.getPrint());
		}
		Output.printText("\n");
	}

	public static Integer gameResult(List<Integer> result) {
		requestPrintf(result);

		return result.get(strike);
	}
	public static List<Integer> compareNumber() {
		return GameService.compareNumber();
	}
	public static void isRestart() {
		Output.printNotice("start");

		do {
			startGame();
			BaseballDto.setUser("restart");
		}while (BaseballDto.getUser().equals("1"));
	}
}
