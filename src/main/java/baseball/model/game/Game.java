package baseball.model.game;

import baseball.model.data.Data;
import baseball.view.Output;

public class Game {
	Data data = new Data();
	Calculation calculation = new Calculation();
	Rule rule = new Rule();
	Referee referee = new Referee();

	public void play() {
		start();
		round();
	}

	public void start() {
		data.fetchComputerNumbers();
	}

	public void round() {
		do {
			Rule.STRIKE = 0;
			Rule.BALL = 0;
			data.fetchUserNumbers();
			calculation.calculateGuess();
			Output.print(referee.getMessage());

			referee.checkUserWin();

		} while (!rule.userWin());

		continueOrExit();
	}

	public void continueOrExit() {
		if (Rule.USER_INTENTION == 1) {
			Rule.USER_INTENTION = 0;
			Rule.USER_WIN = false;
			play();
		}
	}
}
