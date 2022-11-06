package game.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private List<Integer> computersDifferentThreeNumbers = new ArrayList<>();
	private int strike;
	private int ball;

	public Computer() {
		while (computersDifferentThreeNumbers.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computersDifferentThreeNumbers.contains(randomNumber)) {
				computersDifferentThreeNumbers.add(randomNumber);
			}
		}
	}

	public boolean computeAndPrintResult(String userNumbers) {
		String[] userNumbersArr = userNumbers.split("");
		List<String> userNumbersList = Arrays.asList(userNumbersArr);
		for (int user_index = 0; user_index < 3; ++user_index) {
			int number = Integer.parseInt(userNumbersList.get(user_index));
			if (computersDifferentThreeNumbers.contains(number)) {
				ball += 1;
			}
			if (computersDifferentThreeNumbers.contains(number)
				&& user_index == computersDifferentThreeNumbers.indexOf(number)) {
				strike += 1;
				ball -= 1;
			}
		}
	}
}
