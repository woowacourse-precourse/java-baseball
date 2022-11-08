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
	private final int ANSWER_LENGTH = 3;
	private final int RESTART_ANSWER_LENGTH = 1;

	public void start() {
		do {
			proceedGame();
		} while (restartCheck());
	}

	private void proceedGame() {
		OutputView.printGameStartMessage();
		BaseballModel baseballModel = initGame();
		do {
			Validator validator = new TryValidator(InputView.tryAnswerInput(), ANSWER_LENGTH);
			baseballModel.initCount();
			answerCheck(validator.INPUT_VALUE, baseballModel);
			OutputView.printTryResult(baseballModel);
		} while (!isGameWin(baseballModel));
		OutputView.printGameWinMessage();
	}

	private BaseballModel initGame() {
		String randomAnswer = getRandomAnswer();
		return new BaseballModel(randomAnswer);
	}

	protected String getRandomAnswer() {
		String newAnswer = "";
		while (newAnswer.length() < ANSWER_LENGTH){
			int pickedNum = pickNumberInRange(0, 9);
			if (!Util.isStringContainInt(newAnswer, pickedNum)) {
				newAnswer += String.valueOf(pickedNum);
			}
		}
		return newAnswer;
	}

	protected void answerCheck(String tryAnswer, BaseballModel model){
		for (int i = 0; i < tryAnswer.length(); i++) {
			if (model.charAtAnswer(i) == tryAnswer.charAt(i)) {
				model.addStrikeCount();
			} else if (Util.isStringContainChar(model.answer, tryAnswer.charAt(i))) {
				model.addBallCount();
			}
		}
	}

	private boolean restartCheck(){
		Validator restartValidator = new RestartValidator(InputView.restartInput(), RESTART_ANSWER_LENGTH);
		return restartValidator.INPUT_VALUE.equals("1");
	}


	private boolean isGameWin(BaseballModel model) {
		return model.strike == ANSWER_LENGTH;
	}
}