package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.count.Game;
import baseball.player.User;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;
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

	public void compare(User user, List<Integer> computer) {
		for (int i = 0; i < computer.size(); i++) {
			if (computer.get(i) == user.getUserNumber(i)) {
				game.strikeAdd();
				continue;
			}
			if (computer.contains(user.getUserNumber(i))) {
				game.ballAdd();
			}
		}

	}

	public int[] inputNumber() {
		systemMessage.PrintProgress();
		String input = Console.readLine();
		exception.checkSize(input);
		int[] number = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			exception.checkNumberSize(input.charAt(i));
			exception.checkOverlap(number, input.charAt(i));
			number[i] = input.charAt(i) - '0';
		}
		return number;
	}

	public void printCount() {
		System.out.println(systemMessage.PrintCount(game.getStrikeCount(), game.getBallCount()));
	}

	public int computerSize() {
		return computer.size();
	}

	public int strikeCount() {
		return game.getStrikeCount();
	}

	public int ballCount() {
		return game.getBallCount();
	}

}