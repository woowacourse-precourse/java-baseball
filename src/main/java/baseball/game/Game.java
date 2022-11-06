package baseball.game;

import baseball.playerComputer.PlayerComputer;
import baseball.playerUser.PlayerUser;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final Game instance = new Game();
	private static final int STRIKE = 0;
	private static final int BALL = 1;

	private Game() {
	}

	public static Game getInstance() {
		return instance;
	}

	public int play(PlayerComputer computer, PlayerUser user) {
		do {
			String answer = computer.getRandomNumber();
			String userInput = user.getInputNumber();

			List<Integer> judgement = compareUserInputToAnswer(userInput, answer);

			printMessage(judgement);
			int numberOfStrike = judgement.get(STRIKE);
		} while (!isCorrectAnswer(numberOfStrike));

		return askReplay();
	}

	private List<Integer> compareUserInputToAnswer(String userInput, String answer) {
		List<Integer> judgement = new ArrayList<>();
		int strikeCounter = findStrikes(userInput, answer);
		int ballCounter = findBalls(userInput, answer);

		judgement.add(strikeCounter);
		judgement.add(ballCounter);

		return judgement;
	}

	// todo : 리팩토링 명단1
	private int findStrikes(String userInput, String answer) {
		int counter = 0;
		int userNumberLength = userInput.length();

		for (int i = 0; i < userNumberLength; i++) {
			counter += countStrikes(userInput, answer, i);
		}

		return counter;
	}

	// todo : 리팩토링 명단2
	private int countStrikes(String userInput, String answer, int i) {
		char userDigit = userInput.charAt(i);
		char answerDigit = answer.charAt(i);

		if (userDigit == answerDigit) {
			return 1;
		}

		return 0;
	}

	// todo : 리팩토링 명단1
	private int findBalls(String userInput, String answer) {
		int counter = 0;
		int userNumberLength = userInput.length();

		for (int i = 0; i < userNumberLength; i++) {
			counter += countBalls(userInput, answer, i);
		}

		return counter;
	}

	// todo : 리팩토링 명단2
	private int countBalls(String userInput, String answer, int i) {
		char userDigit = userInput.charAt(i);
		char answerDigit = answer.charAt(i);

		if (userDigit != answerDigit && answer.contains("" + userDigit)) {
			return 1;
		}

		return 0;
	}

	private void printMessage(List<Integer> judgement) {
		String msg = generateMessage(judgement);
		System.out.println(message);
	}



}
