package baseball.controller;

import baseball.model.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
	private final int CORRECT_LENGTH = 3;
	public void start(){
		OutputView.gameStartView();
		Validator tryValidator = new Validator(InputView.tryAnswerInput(), CORRECT_LENGTH);
	}
}