package baseball.rule;

import baseball.player.Computer;
import baseball.player.Player;

public class BaseballGameRule {

	private Player player;
	private Computer computer;

	private String playerNumber;

	private String computerNumber;

	private static final String NUMBER_START = "1";
	private static final String NUMBER_END = "9";

	private static final int NUMBER_LENGTH = 3;

	public BaseballGameRule(Player player, Computer computer) {
		this.player = player;
		this.computer = computer;
		computerNumber = computer.getNumber();
	}

	public void isPlayerNumberValidate() {
		playerNumber = player.getNumber();
		if (!isLength3() || !isNumber()) {
			throw new IllegalArgumentException("올바른 값을 입력하세요(서로 다른 숫자 3개");
		}
	}

	private boolean isLength3() {
		return playerNumber.length() == NUMBER_LENGTH;
	}

	private boolean isNumber() {
		return playerNumber.matches("^[" + NUMBER_START + "-" + NUMBER_END + "]*$");
	}


}
