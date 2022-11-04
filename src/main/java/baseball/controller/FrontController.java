package baseball.controller;

import java.util.List;

import baseball.domain.UserBall;
import baseball.service.GameEndService;
import baseball.service.GameStartService;
import baseball.service.UserBallService;
import baseball.util.ErrorConst;
import baseball.util.InputValidUtil;
import baseball.util.ViewConst;
import camp.nextstep.edu.missionutils.Console;

public class FrontController {

	private final GameStartService gameStartService;
	private final UserBallService userBallService;
	private final GameEndService gameEndService;
	private final InputValidUtil inputValidUtil;

	public FrontController(GameStartService gameStartService, UserBallService userBallService,
		GameEndService gameEndService, InputValidUtil inputValidUtil) {
		this.gameStartService = gameStartService;
		this.userBallService = userBallService;
		this.gameEndService = gameEndService;
		this.inputValidUtil = inputValidUtil;
	}

	public void startApplication() {
		do {
			startGame();
		} while (!exit());
	}

	public void startGame() {

		List<Integer> answerNumber = gameStartService.initGame();
		String userInputNum;
		UserBall userBall;
		do {
			userInputNum = Console.readLine();
			inputValidUtil.checkInputValid(userInputNum);
			userBall = userBallService.makeUserBall(userInputNum, answerNumber);
		} while (!gameEndService.isAnswer(userBall));

	}

	public boolean exit() {
		String isAgain = Console.readLine();
		if (isAgain.equals(ViewConst.RESTART)) {
			return false;
		}
		if (isAgain.equals(ViewConst.END)) {
			return true;
		}
		throw new IllegalArgumentException(ErrorConst.RESTART_END_ERROR);
	}

}
