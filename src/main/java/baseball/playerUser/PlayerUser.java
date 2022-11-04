package baseball.playerUser;

import camp.nextstep.edu.missionutils.Console;

public class PlayerUser {
	private static final PlayerUser instance = new PlayerUser();

	private PlayerUser() {
	}

	public static PlayerUser getInstance() {
		return instance;
	}

	private String inputNumber() {
		return Console.readLine();
	}

}
