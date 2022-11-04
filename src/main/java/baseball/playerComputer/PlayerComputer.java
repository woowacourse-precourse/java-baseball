package baseball.playerComputer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

// todo: 싱글톤 객체로 만드는게 가능하지 않나?
public class PlayerComputer {
	public int getRandomInputNumber() {
		HashMap<Integer, Integer> digits;
		digits = generateInputNumber();


	}

	private HashMap<Integer, Integer> generateInputNumber() {
		HashMap<Integer, Integer> digits = new HashMap<>();
		while (!isqualifiedNumber(digits)) {
			int randomDigit = getRandomDigit();
			if (isAbleToAddDigit(digits)) {
				int order = digits.size() + 1;
				// randomDigit는 유일한 값이므로 key, order는 value로 삽입된 순서(1부터 시작)
				digits.put(randomDigit, order);
				continue;
			}
			break;
		}
		return digits;
	}

	private static int getRandomDigit() {
		return Randoms.pickNumberInRange(1, 9);
	}

	private boolean isAbleToAddDigit(HashMap<Integer, Integer> digits) {
		return digits.size() <= 3;
	}

	private boolean isqualifiedNumber(HashMap<Integer, Integer> digits) {
		return digits.size() == 3;
	}
}
