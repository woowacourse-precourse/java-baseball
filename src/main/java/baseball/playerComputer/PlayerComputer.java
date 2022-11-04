package baseball.playerComputer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class PlayerComputer {
	private static HashMap<Integer, Integer> digits;

	private static int getRandomDigit() {
		return Randoms.pickNumberInRange(1, 9);
	}

	public int getRandomInputNumber() {


	}

	private HashMap<Integer, Integer> generateInputNumber() {
		HashMap<Integer, Integer> digits = new HashMap<>();
		while (!isqualifiedNumber(digits)) {
			int
		}
	}

	private boolean isqualifiedNumber(HashMap<Integer, Integer> digits) {
		return digits.size() == 3;
	}
}
