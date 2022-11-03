package baseball.controller;

import java.util.List;

import baseball.service.GameStartService;
import baseball.service.UserBallService;
import baseball.util.InputValidUtil;
import camp.nextstep.edu.missionutils.Console;

public class FrontController {

	private final GameStartService gameStartService;
	private final UserBallService userBallService;
	private final InputValidUtil inputValidUtil;

	public FrontController(GameStartService gameStartService, UserBallService userBallService,
		InputValidUtil inputValidUtil) {
		this.gameStartService = gameStartService;
		this.userBallService = userBallService;
		this.inputValidUtil = inputValidUtil;
	}

	public void startApplication() {

	}

	public void startGame() {

		List<Integer> answerNumber = gameStartService.makeAnswerNumber();
		String userInput;
		do {
			userInput = Console.readLine();
			inputValidUtil.checkInputValid(userInput);
		} while ();//입력값 정답 체크
	}

	public boolean exit() {

	}

}
