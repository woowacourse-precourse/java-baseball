package Controller;

import static User.Outputs.*;

public class Printer {
	public static void printGameStartMessage() {
		System.out.println(GAME_START_MESSAGE.get());
	}

	public static void printAskInputMessage() {
		System.out.print(ASK_INPUT_MESSAGE.get());
	}

	public static void printNothingMessage() {
		System.out.println(NOTHING_MESSAGE.get());
	}
}
