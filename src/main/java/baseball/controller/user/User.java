package baseball.controller.user;

import baseball.view.Input;
import baseball.view.Output;

import java.util.LinkedHashMap;

import static baseball.controller.Setup.*;

public class User {
	Output output = new Output();
	Input input = new Input();

	public LinkedHashMap<Integer, Integer> getNumbers() {
		output.print(REQUEST_NUMBER_MESSAGE.getValue());
		String guessingNumbers = input.getInput();

		UserError.handleGuessingError(guessingNumbers);

		return InputProcess.storeNumbers(guessingNumbers);
	}

	public int getIntention() {
		output.print(REQUEST_INTENTION_MESSAGE.getValue());
		String intention = input.getInput();

		UserError.handleIntentionError(intention);

		return Integer.parseInt(intention);
	}

}
