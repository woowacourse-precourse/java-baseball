package Controller;

import static User.Outputs.*;

public class Printer {
	public static void printGameStartMessage() {
		System.out.println(GAME_START_MESSAGE.get());
	}

	public static void printAskInputMessage() {
		System.out.print(ASK_INPUT_MESSAGE.get());
	}

	public static void printStrikesCountMessage(int strikesCount) {
		System.out.printf(STRIKES_COUNT_MESSAGE.get(), strikesCount);
	}
	public static void printBallsCountMessage(int ballsCount) {
		System.out.printf(BALLS_COUNT_MESSAGE.get(), ballsCount);
	}

	public static void printNothingMessage() {
		System.out.println(NOTHING_MESSAGE.get());
	}
}
