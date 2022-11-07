package baseball.dto;

import baseball.controller.BaseballController;
import baseball.utils.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

public class BaseballDto {
	private static String computer;
	private static String user;

	public static void setComputer() {
		computer = BaseballController.createComputerNumber();
	}

	public static void setUser(String type) {
		user = Console.readLine();
		checkException(type);
	}

	public static void checkException(String type) {
		if (type.equals("user")) {
			ExceptionHandler.checkUserException(user);
		}
		if (type.equals("restart")) {
			ExceptionHandler.checkStopException(user);
		}
	}

	public static String getComputer() {
		return computer;
	}

	public static String getUser() {
		return user;
	}
}
