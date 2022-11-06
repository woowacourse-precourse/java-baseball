package baseball.controller;

import java.util.List;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private static AnswerController answerController;

	private GameController() {}

	public static void run() {
		init();
		answerController.setCorrectAnswer();
		answerController.getInputAnswer();
	}

	private static void init() {
		OutputView.gameStart();
		answerController = AnswerController.getInstance();
	}

}
