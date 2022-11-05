package baseball.model.game;

import baseball.model.data.Data;
import baseball.view.Output;

public class Game {
	Output output = new Output();
	Data data = new Data();
	Calculation calculation = new Calculation();
	Rule rule = new Rule();
	Judge judge = new Judge();

	public void play() {

		start();
		round();

	}

	public void start() {
		data.fetchComputerNumbers();
	}

	public void round() {
		do {
			rule.STRIKE = 0;
			rule.BALL = 0;
			data.fetchUserNumbers();
			calculation.calculateGuess();
			output.print(judge.getMessage());

			judge.checkUserWin();

		} while (!rule.userWin());

		continueOrExit();
	}


	public void continueOrExit() {
		if (rule.USER_INTENTION == 1) {
			rule.USER_INTENTION = 0;
			rule.USER_WIN = false;
			play();
		}
	}

}
