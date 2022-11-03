package baseball.view;

import baseball.common.Constants;
import baseball.controller.dto.UserPlayNumbers;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {
	public void initPage() {
		System.out.println(Constants.WELCOME_MESSAGE);
	}

	public UserPlayNumbers playPage() {
		System.out.print(Constants.NUMBER_INPUT_PLACE_HOLDER);
		String userInput = Console.readLine();

		return new UserPlayNumbers(userInput);
	}
}
