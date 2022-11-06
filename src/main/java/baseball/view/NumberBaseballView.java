package baseball.view;

import baseball.common.MessageConstants;
import baseball.controller.dto.UserInputPlayNumbers;
import baseball.controller.dto.UserInputRestartCode;
import baseball.model.gameresult.GameResult;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {
	public void initPage() {
		System.out.println(MessageConstants.WELCOME_MESSAGE);
	}

	public UserInputPlayNumbers playPage() {
		System.out.print(MessageConstants.NUMBER_INPUT_PLACE_HOLDER);
		String userInput = Console.readLine();

		return new UserInputPlayNumbers(userInput);
	}

	public void resultPage(GameResult gameResult) {
		System.out.println(gameResult);
	}

	public void endPage() {
		System.out.println(MessageConstants.END_GAME_MESSAGE);
	}

	public UserInputRestartCode restartPage() {
		System.out.println(MessageConstants.GAME_RESTART_MESSAGE);
		String userInput = Console.readLine();

		return new UserInputRestartCode(userInput);
	}
}
