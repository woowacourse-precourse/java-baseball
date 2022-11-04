package baseball.view;

import baseball.common.Constants;
import baseball.controller.dto.UserInputPlayNumbers;
import baseball.model.gameresult.GameResult;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {
	public void initPage() {
		System.out.println(Constants.WELCOME_MESSAGE);
	}

	public UserInputPlayNumbers playPage() {
		System.out.print(Constants.NUMBER_INPUT_PLACE_HOLDER);
		String userInput = Console.readLine();

		return new UserInputPlayNumbers(userInput);
	}

	public void resultPage(GameResult gameResult) {
		System.out.println(gameResult);
	}

	public void endPage() {
		System.out.println(Constants.END_GAME_MESSAGE);
	}
}
