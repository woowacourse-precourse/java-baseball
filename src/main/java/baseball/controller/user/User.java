package baseball.controller.user;

import baseball.controller.error.UserError;
import baseball.model.data.UserNumbers;
import baseball.view.Output;

import java.util.LinkedHashMap;

import static baseball.controller.Setup.*;

public class User {
	Input input = new Input();

	public LinkedHashMap<Integer, Integer> getNumbers() {
		Output.print(REQUEST_NUMBER_MESSAGE.getValue());
		String guessingNumbers = input.getInput();

		UserError.handleGuessingError(guessingNumbers);

		return UserNumbers.storeNumbers(guessingNumbers);
	}

	public int getIntention() {
		Output.print(REQUEST_INTENTION_MESSAGE.getValue());
		String intention = input.getInput();

		UserError.handleIntentionError(intention);

		return Integer.parseInt(intention);
	}

}
