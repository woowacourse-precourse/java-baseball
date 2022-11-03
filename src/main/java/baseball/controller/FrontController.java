package baseball.controller;

import java.util.List;

import baseball.service.GameStartService;
import baseball.service.UserBallService;
import baseball.util.InputValidUtil;

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
		List<Integer> answerNumber;
		String userInput;
		//정답 숫자 만들기
		do {
			//입력값 받기
			//입력값 타당성 체크
		} while ();//입력값 정답 체크
	}

	public boolean exit() {

	}

}
