package baseball;

import static baseball.Validator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
	public static String getUserBallsNumbers() {
		String userBallsNumber = Console.readLine();
		validateBallsInput(userBallsNumber);

		return userBallsNumber;
	}

	public static String getQuitOrRestart() {
		String quitOrRestart = Console.readLine();
		validateQuitOrRestartInput(quitOrRestart);

		return quitOrRestart;
	}
}
