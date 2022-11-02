package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
	final int min = 1;
	final int max = 9;

	public int createRandomNumber() {
		return Randoms.pickNumberInRange(min, max);
	}
}
