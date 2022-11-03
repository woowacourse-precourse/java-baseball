package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Baseball {
	private static final int PLAYING_NUMBER_SIZE = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	static String make3DigitNumber() {
		StringBuilder stringBuilder = new StringBuilder();
		List<Integer> prev = new ArrayList<>();

		while (stringBuilder.length() != PLAYING_NUMBER_SIZE) {
			int newNumber = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

			if (!prev.contains(newNumber)) {
				stringBuilder.append(newNumber);
				prev.add(newNumber);
			}
		}
		return stringBuilder.toString();
	}

	static List<Integer> splitDigits(String threeDigitNumber) {
		if (threeDigitNumber.equals("")) {
			return Collections.emptyList();
		}
		List<String> splitString = new ArrayList<>(Arrays.asList(threeDigitNumber.split("")));
		return splitString.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

}
