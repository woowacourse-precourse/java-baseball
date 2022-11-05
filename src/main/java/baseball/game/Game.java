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

	private int findStrikes(String userInput, String answer) {
		int counter = 0;
		int userNumberLength = userInput.length();

		for (int i = 0; i < userNumberLength; i++) {
			counter += countStrikes(userInput, answer, i);
		}

		return counter;
	}



	private int findBalls(String userInput, String answer) {
	}



}
