package baseball.controller;

import baseball.constant.GameConstants;
import baseball.util.Validator;
import baseball.view.InputView;

public class RestartController {
	public boolean restart() {
		InputView inputView = new InputView();
		String response = inputView.getRestartResponse();
		Validator.validateRestartOrNotInput(response);
		return response.equals(GameConstants.RESTART_GAME);
	}
}
