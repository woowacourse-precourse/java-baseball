package baseball.playerComputer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class PlayerComputer {
	private static final PlayerComputer instance = new PlayerComputer();

	private PlayerComputer() {
	}

	public static PlayerComputer getInstance() {
		return instance;
	}

	public String getRandomNumber() {
		HashMap<Integer, Integer> digits = generateNumber();
		return combineDigits(digits);
	}

	private HashMap<Integer, Integer> generateNumber() {
		HashMap<Integer, Integer> digits = new HashMap<>();
		while (isAbleToAddDigit(digits)) {
			int randomDigit = getRandomDigit();
			int order = digits.size() + 1;
			// randomDigit는 유일한 값이므로 key, order는 value로 삽입된 순서(1부터 시작)
			digits.put(randomDigit, order);
		}
		return digits;
	}

	private String combineDigits(HashMap<Integer, Integer> digits) {
		StringBuilder number = new StringBuilder();

		for (Integer randomNumber : digits.keySet()) {
			number.append(randomNumber.toString());
		}

		return number.toString();
	}

	private boolean isAbleToAddDigit(HashMap<Integer, Integer> digits) {
		return digits.size() < 3;
	}

	private static int getRandomDigit() {
		return Randoms.pickNumberInRange(1, 9);
	}
}
