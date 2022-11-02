package baseball.controller;

import baseball.model.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballController {
	private final int CORRECT_LENGTH = 3;
	private String answer = "";
	public void start(){
		OutputView.gameStartView();
		setRandomAnswer();
		Validator tryValidator = new Validator(InputView.tryAnswerInput(), CORRECT_LENGTH);
	}

	private void setRandomAnswer(){
		while (answer.length() < CORRECT_LENGTH){
			int pickedNum = pickNumberInRange(0, 9);
			if (!answer.contains(String.valueOf(pickedNum))){
				answer += String.valueOf(pickedNum);
			}
		}
	}
}