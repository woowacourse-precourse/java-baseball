package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.count.Game;
import baseball.player.User;
import baseball.view.SystemMessage;

public class GameService {
	Game game = new Game();
	User user = new User();
	SystemMessage systemMessage = new SystemMessage();
	Exception exception = new Exception();

	List<Integer> computer = new ArrayList<>();

	public void playGame() {
		int strike = 0;
		while (strike != 3) {
			play();
			printCount();
			strike = game.getStrikeCount();
		}
	}

}