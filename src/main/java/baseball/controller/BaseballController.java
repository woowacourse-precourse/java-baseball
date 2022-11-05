package baseball.controller;

import baseball.Util;
import baseball.model.BaseballModel;
import baseball.model.RestartValidator;
import baseball.model.TryValidator;
import baseball.model.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballController {
	protected final int ANSWER_LENGTH = 3;
	private final int RESTART_ANSWER_LENGTH = 1;
//	protected String answer;
//	protected int strike;
//	protected int ball ;

	public void start(){
		do{
			proceedGame();
		}while(restartCheck());
	}

	private void proceedGame() {
		OutputView.printGameStartMessage();
		BaseballModel baseballModel = initGame();
		do {
			Validator tryValidator = new TryValidator(InputView.tryAnswerInput(), ANSWER_LENGTH);
			answerCheck(tryValidator.INPUT_VALUE, baseballModel);
			OutputView.tryResultView(baseballModel);
		} while (!isGameWin(baseballModel));
		OutputView.gameWinView();
	}

	protected BaseballModel initGame() {
		String randomAnswer = getRandomAnswer();
		return new BaseballModel(randomAnswer);
	}

	protected String getRandomAnswer(){
		String newAnswer = "";
		while (newAnswer.length() < ANSWER_LENGTH){
			int pickedNum = pickNumberInRange(0, 9);
			if (!Util.isStringContainInt(newAnswer, pickedNum)){
				newAnswer += String.valueOf(pickedNum);
			}
		}
		return newAnswer;
	}

	protected void answerCheck(String tryAnswer, BaseballModel model){
		model.resetCount();
		for (int i = 0; i < tryAnswer.length(); i++) {
			if (model.charAtAnswer(i) == tryAnswer.charAt(i)){
				model.addStrikeCount();
			} else if (Util.isStringContainChar(model.answer, tryAnswer.charAt(i))){
				model.addBallCount();
			}
		}
	}

	private boolean restartCheck(){
		Validator restartValidator = new RestartValidator(InputView.restartInput(), RESTART_ANSWER_LENGTH);
		return restartValidator.INPUT_VALUE.equals("1");
	}


	protected boolean isGameWin(BaseballModel model){
		return model.strike == ANSWER_LENGTH;
	}
}