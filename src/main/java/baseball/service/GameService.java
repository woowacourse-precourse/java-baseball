package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.count.Game;
import baseball.player.User;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Randoms;

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

	public void play() {
		user.userReset();
		game.gameSetting();
		user.setUserNumber(inputNumber());
		compare(user, computer);
	}

	public void ramdomNumberSetting() {
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
	}

}