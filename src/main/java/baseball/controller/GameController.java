package baseball.controller;

import java.util.List;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private static AnswerController answerController;
	private static ResultController resultController;

	private GameController() {}

	public static void run() {
		init();
		answerController.setCorrectAnswer();
		String guessAnswer = answerController.getInputAnswer();
		boolean success = resultController.getResult(guessAnswer);
	}

	private static void init() {
		OutputView.gameStart();
		answerController = AnswerController.getInstance();
		resultController = ResultController.getInstance();
	}

}
