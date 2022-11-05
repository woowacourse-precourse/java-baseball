package Controller;

import static Controller.Printer.*;
import static User.Input.*;
import static User.Validator.*;
import static baseball.Constant.*;

public class Restarter {
	public static boolean restart() {
		printRestartOrNotMessage(RESTART_GAME, END_GAME);

		String response = getUserInput();
		validateRestartOrNotInput(response);
		return response.equals(RESTART_GAME);
	}
}
