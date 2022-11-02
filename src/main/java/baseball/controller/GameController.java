package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
	final int min = 1;
	final int max = 9;

	public String gameStart() {
		GameService gs = new GameService();

		return gs.createRandomNumber();
	}

	public void saveUserNumber(String userNumber) {
		GameService gs = new GameService();

		gs.checkException(userNumber);
	}
}
