package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class QuestionNumberSetter {
	public List<Integer> pickThreeRandomNumbers() {
		List<Integer> randomNumbers = new ArrayList<>();

		while (randomNumbers.size() < 3) {
			int oneNumber = Randoms.pickNumberInRange(1, 9);
			if (randomNumbers.contains(oneNumber) == false) {
				randomNumbers.add(oneNumber);
			}
		}

		return randomNumbers;
	}
}
