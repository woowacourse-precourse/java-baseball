package baseball.controller;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.service.AnswerService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class AnswerController {
	private static AnswerController instance;
	private static AnswerService answerService;

	private AnswerController() {}

	public static AnswerController getInstance() {
		if(instance == null) {
			instance = new AnswerController();
			answerService = AnswerService.getInstance();
		}
		return instance;
	}

	public void setCorrectAnswer() {
		answerService.setRandomNumbers();
	}

	public void getInputAnswer() {
		OutputView.alertInputAnswer();
		answerService.validateInputAnswer(InputView.getInput());
	}
}
