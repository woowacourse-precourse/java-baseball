package baseball.controller;

import baseball.Util;
import baseball.model.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballController {
	protected final int ANSWER_LENGTH = 3;
	protected String answer;
	private int strike;
	private int ball ;
	public void start(){
		OutputView.gameStartView();
		initGame();
		do {
			Validator tryValidator = new Validator(InputView.tryAnswerInput(), ANSWER_LENGTH);
			answerCheck(tryValidator.INPUT_VALUE);
			OutputView.displayResult(ball, strike);
		} while (!isGameWin());
	}

	private void initGame() {
		answer = "";
		setRandomAnswer();
	}

	private void setRandomAnswer(){
		while (answer.length() < ANSWER_LENGTH){
			int pickedNum = pickNumberInRange(0, 9);
			if (!Util.isStringContainInt(answer, pickedNum)){
				answer += String.valueOf(pickedNum);
			}
		}
	}

	private void answerCheck(String tryAnswer){
		strike = 0;
		ball = 0;
		for (int i = 0; i < tryAnswer.length(); i++) {
			if (answer.charAt(i) == tryAnswer.charAt(i)){
				strike++;
			} else if (Util.isStringContainChar(answer, tryAnswer.charAt(i))){
				ball++;
			}
		}
	}

	private boolean isGameWin(){
		return this.strike == ANSWER_LENGTH;
	}
}