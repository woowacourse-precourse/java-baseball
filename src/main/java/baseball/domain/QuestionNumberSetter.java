package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseball.constants.ComparingResults;
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

	public Map<ComparingResults, Integer> compareWithRandomNumbers(List<Integer> inputNumbers) {
		Map<ComparingResults, Integer> comparingResult = new HashMap<>();

		for (int i = 0; i < inputNumbers.size(); i++) {
			int inputNumberPosition = i;
			int inputNumber = inputNumbers.get(i);

			if (randomNumbers.contains(inputNumber)) {
				int randomNumberPosition = randomNumbers.indexOf(inputNumber);
				int count = 1;

				if (randomNumberPosition == inputNumberPosition) {
					if (comparingResult.containsKey(ComparingResults.STRIKE)) {
						count = comparingResult.get(ComparingResults.STRIKE) + 1;
					}

					comparingResult.put(ComparingResults.STRIKE, count);

					continue;
				}

				if (comparingResult.containsKey(ComparingResults.BALL)) {
					count = comparingResult.get(ComparingResults.BALL) + 1;
				}

				comparingResult.put(ComparingResults.BALL, count);
			}
		}

		if (comparingResult.isEmpty() == true) {
			comparingResult.put(ComparingResults.NOTHING, 1);
		}

		return comparingResult;
	}
}
