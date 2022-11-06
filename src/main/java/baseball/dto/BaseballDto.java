package baseball.dto;

import baseball.controller.GameController;
import baseball.utils.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

public class BaseballDto {
	private static String computer;
	private static String user;
	public static void setComputer() {
		computer = GameController.createComputerNumber();
	}
	public static void setUser() {
		user = Console.readLine();
		checkErrorNumber();
	}
	public static void checkErrorNumber() {
		ExceptionHandler.checkException(user);
	}
	public static String getComputer() {
		return computer;
	}
	public static String getUser() {
		return user;
	}
}
