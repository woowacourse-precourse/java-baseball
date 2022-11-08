package baseball.util;

import static baseball.constant.GameConstants.LENGTH_OF_NUMBER;
import static baseball.constant.GameConstants.VALID_DIGITS;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator {
	public static List<Integer> generate() {
		List<Integer> randomNumber = new ArrayList<>();

		while (randomNumber.size() < LENGTH_OF_NUMBER) {
			randomNumber.add(pickNumberInRange(Collections.min(VALID_DIGITS), Collections.max(VALID_DIGITS)));
			randomNumber = randomNumber.stream().distinct().collect(Collectors.toList());
		}

		return randomNumber;
	}
}
