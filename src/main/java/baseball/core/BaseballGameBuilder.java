package baseball.core;

import baseball.model.CompareResultDto;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Progress;
import baseball.views.View;

public class BaseballGameBuilder implements GameBuilder {
	private Computer computer;
	private Player player;
	private View show;

	@Override
	public GameBuilder initGame(Computer computer, Player player) {
		this.computer = computer;
		this.player = player;
		show = new View();

		return this;
	}

	@Override
	public GameBuilder executeGame() {
		show.startMessage();

		do {
			String userBaseballNumber = show.baseballInput();
			player.setCurrentUserAnswer(userBaseballNumber);
			CompareResultDto compareResult = computer.countBallAndStrike(player);

			show.hintMessage(compareResult);
		} while (!computer.isAnswer(player));

		return this;
	}

	@Override
	public Progress exitGame() {
		int userProgressCode = show.endMessage();

		return Progress.askRestartOrExitGameFromUser(userProgressCode);
	}
}
