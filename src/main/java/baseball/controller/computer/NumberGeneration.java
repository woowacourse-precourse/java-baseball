package baseball.controller.computer;

import baseball.controller.error.ComputerError;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGeneration {
	static void generateMultipleRandomNumber(List<Integer> randomNumbers) {
		do {
			int createdNumber = generateOneRandomNumber();

			if (ComputerError.followDuplicationRule(randomNumbers, createdNumber)) {
				randomNumbers.add(createdNumber);
			}

		} while (!ComputerError.followDigitRule(randomNumbers));
	}

	public static int generateOneRandomNumber() {
		return Randoms.pickNumberInRange(1, 9);
	}
}
