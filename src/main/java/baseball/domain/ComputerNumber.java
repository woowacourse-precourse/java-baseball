package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumber {
	private static final int NUMBER_LENGTH = 3;
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 9;
	private final List<Integer> computerNumber;

	public ComputerNumber() {
		this.computerNumber = createRandomNumber();
	}

	private List<Integer> createRandomNumber() {
		List<Integer> randomNumbers = pickRandomNumber();
		if (!isDuplicate(randomNumbers)) {
			return randomNumbers;
		}
		return createRandomNumber();
	}

	private List<Integer> pickRandomNumber() {
		return Arrays.stream(new List[NUMBER_LENGTH])
			.map(num -> Randoms.pickNumberInRange(START_RANGE, END_RANGE))
			.collect(Collectors.toList());
	}

	private boolean isDuplicate(List<Integer> randomNums) {
		return NUMBER_LENGTH != randomNums.stream().distinct().count();
	}

	public List<Integer> getComputerNumber() {
		return computerNumber;
	}
}
