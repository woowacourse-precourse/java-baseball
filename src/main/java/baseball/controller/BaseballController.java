package baseball.controller;

import baseball.Util;
import baseball.model.RestartValidator;
import baseball.model.TryValidator;
import baseball.model.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballController {
	protected final int ANSWER_LENGTH = 3;
	private final int RESTART_ANSWER_LENGTH = 1;
	protected String answer;
	protected int strike;
	protected int ball ;

	public void start(){
		do{
			proceedGame();
		}while(restartCheck());
	}

	private void proceedGame() {
		OutputView.gameStartView();
		initGame();
		do {
			Validator tryValidator = new TryValidator(InputView.tryAnswerInput(), ANSWER_LENGTH);
			answerCheck(tryValidator.INPUT_VALUE);
			OutputView.tryResultView(ball, strike);
		} while (!isGameWin());
		OutputView.gameWinView();
	}
	private boolean restartCheck(){
		Validator restartValidator = new RestartValidator(InputView.restartInput(), RESTART_ANSWER_LENGTH);
		return restartValidator.INPUT_VALUE.equals("1");
	}

	protected void initGame() {
		answer = "";
		strike = 0;
		ball = 0;
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

	protected void answerCheck(String tryAnswer){
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

	protected boolean isGameWin(){
		return this.strike == ANSWER_LENGTH;
	}
}