package baseball.controller.dto;

import baseball.model.restartcode.RestartStatus;
import baseball.util.UserInputValidator;

public class UserInputRestartCode {
	private final String restartCode;

	public UserInputRestartCode(String restartCode) {
		UserInputValidator.validateRestartCode(restartCode);
		this.restartCode = restartCode;
	}

	public RestartStatus toRestartCode() {
		int restartStatusCode = Integer.parseInt(this.restartCode);
		return RestartStatus.valueOfCode(restartStatusCode);
	}

}
