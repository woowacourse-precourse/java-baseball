package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
	final int min = 1;
	final int max = 9;

	public String createRandomNumber() {
		String randomNumber = "";

		for (int i = 0; i < 3; i++)
			randomNumber += Randoms.pickNumberInRange(min, max);

		return randomNumber;
	}

}
