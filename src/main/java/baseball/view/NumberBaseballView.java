package baseball.view;

import static baseball.common.Constant.*;

import baseball.controller.dto.UserPlayNumbers;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {
	public void initPage() {
		System.out.println(WELCOME_MESSAGE);
	}

	public UserPlayNumbers playPage() {
		System.out.print(NUMBER_INPUT_PLACE_HOLDER);
		String userInput = Console.readLine();

		return new UserPlayNumbers(userInput);
	}
}
