package baseball.controller;

import baseball.model.Validator;
import baseball.view.InputView;

public class BaseballController {
	private final int CORRECT_LENGTH = 3;
	public void start(){
		Validator tryValidator = new Validator(InputView.tryAnswerInput(), CORRECT_LENGTH);
	}
}