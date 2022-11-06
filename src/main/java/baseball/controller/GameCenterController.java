package baseball.controller;

import java.util.List;

import baseball.domain.UserBall;
import baseball.service.UserBallService;
import baseball.util.ErrorConst;
import baseball.util.InputValidUtil;
import baseball.util.ViewConst;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameCenterController {

	private final GameStartController gameStartController;
	private final UserBallService userBallService;
	private final GameEndController gameEndController;
	private final InputValidUtil inputValidUtil;
	private final OutputView outputView;

	public GameCenterController(GameStartController gameStartController, UserBallService userBallService,
		GameEndController gameEndController, InputValidUtil inputValidUtil, OutputView outputView) {
		this.gameStartController = gameStartController;
		this.userBallService = userBallService;
		this.gameEndController = gameEndController;
		this.inputValidUtil = inputValidUtil;
		this.outputView = outputView;
	}

	public void startApplication() {
		do {
			startGame();
		} while (!exit());
	}

	public void startGame() {
		List<Integer> answerNumber = gameStartController.initGame();
		String userInputNum;
		UserBall userBall;
		do {
			userInputNum = Console.readLine();
			inputValidUtil.checkInputValid(userInputNum);
			userBall = userBallService.makeUserBall(userInputNum, answerNumber);
			outputView.printUserBallStatus(userBall);
		} while (!gameEndController.isAnswer(userBall));
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
