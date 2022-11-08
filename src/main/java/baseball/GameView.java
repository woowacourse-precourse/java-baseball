package baseball;

import static baseball.Constants.*;

public class GameView {
	private GameView() {
	}

	public static void printStartGame() {
		System.out.println(START_GAME);
	}

	public static void printInstruction() {
		System.out.print(INPUT_INSTRUCTION);
	}

	public static void printStrike(int strikeCount) {
		System.out.println(strikeCount + STRIKE);
	}

	public static void printBall(int ballCount) {
		System.out.println(ballCount + BALL);
	}

	public static void printBallAndStrike(int ballCount) {
		System.out.print(ballCount + BALL + " ");
	}

	public static void printNothing() {
		System.out.println(NOTHING);
	}

	public static void printEndGame() {
		System.out.println(END_GAME);
	}

	public static void printRestartInstruction() {
		System.out.println(RESTART_INSTRUCTION);
	}
}
