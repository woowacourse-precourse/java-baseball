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
		printResult();
		if (strike == 3) {
			return true;
		}
		resetBallAndStrike();
		return false;
	}

	private void resetBallAndStrike() {
		this.ball = 0;
		this.strike = 0;
	}

	private void printResult() {
		String str = "";
		if (ball != 0) {
			str += ball + "볼 ";
		}
		if (strike != 0) {
			str += strike + "스트라이크";
		}
		else if (ball == 0) {
			str += "낫싱";
		}
		System.out.println(str);
	}
}
