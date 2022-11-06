package baseball.controller;

import static baseball.constant.GameConstants.*;
import static baseball.utils.Input.*;

import baseball.utils.Validator;
import baseball.view.Printer;

public class Restarter {
	public static boolean restart() {
		Printer.printRestartOrNotMessage(RESTART_GAME, END_GAME);

		String response = getUserInput();
		Validator.validateRestartOrNotInput(response);
		return response.equals(RESTART_GAME);
	}
}
