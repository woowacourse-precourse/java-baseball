package baseball.game;

import baseball.playerComputer.PlayerComputer;
import baseball.playerUser.PlayerUser;

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
}
