package baseball;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.util.StringToArrayList;
import baseball.util.SystemMessage;

import java.util.List;

public class Game {

	Player player = new Player();

	private String getPlayerInput() throws IllegalArgumentException {
		String playerInput = player.getInput();
		List<Integer> playerInputArray = StringToArrayList.convert(playerInput);

		if (playerInput.length() != 3) {
			System.out.println(playerInput);
			throw new IllegalArgumentException(SystemMessage.printError());
		}

		if (playerInputArray.contains(0)) {
			System.out.println(playerInput);
			throw new IllegalArgumentException(SystemMessage.printError());
		}

		if (playerInputArray.size() != playerInputArray.stream().distinct().count()) {
			System.out.println(playerInput);
			throw new IllegalArgumentException(SystemMessage.printError()); //TODO: 에러 메시지 프린트 안되고 있음
		}

		return playerInput;
	}

	private void start() {
		SystemMessage.printStart();
	}

}
