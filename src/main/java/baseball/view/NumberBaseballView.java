package baseball.view;

import baseball.common.Constants;
import baseball.controller.dto.UserInputPlayNumbers;
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
}
