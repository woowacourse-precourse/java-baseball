package baseball.view;

import static baseball.common.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballView {

	public void initPage() {
		System.out.println(WELCOME_MESSAGE);
	}

	public String playPage() {
		System.out.print(NUMBER_INPUT_PLACE_HOLDER);
		return Console.readLine();
	}
}
