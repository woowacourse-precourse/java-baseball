package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class QuestionNumberSetter {
	private List<Integer> randomNumbers = new ArrayList<>();

	public List<Integer> pickThreeRandomNumbers() {
		while (randomNumbers.size() < 3) {
			int uniqueNumber = pickUniqueRandomNumber();
			randomNumbers.add(uniqueNumber);
		}

		return randomNumbers;
	}

	private int pickUniqueRandomNumber() {
		int uniqueNumber = 0;

		do {
			uniqueNumber = Randoms.pickNumberInRange(1, 9);
		} while (randomNumbers.contains(uniqueNumber));

		return uniqueNumber;
	}
}
