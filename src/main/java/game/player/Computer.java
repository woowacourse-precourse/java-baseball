package game.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private final List<Integer> computersDifferentThreeNumbers = new ArrayList<>();
	private int strike;
	private int ball;

	public Computer() {
		createThreeNumbers();
	}

	private void createThreeNumbers() {
		for (int i = 0; i < 3; ++i) {
			addNumber();
		}
	}

	private void addNumber() {
		int randomNumber = Randoms.pickNumberInRange(1, 9);
		if (!computersDifferentThreeNumbers.contains(randomNumber)) {
			computersDifferentThreeNumbers.add(randomNumber);
		}
	}

	public boolean computeAndPrintResult(String userNumbers) {
		compute(userNumbers);
		printResult();
		return strike == 3;
	}

	private void compute(String userNumbers) {
		String[] userNumbersArr = userNumbers.split("");
		List<String> userNumbersList = Arrays.asList(userNumbersArr);

		for (int user_index = 0; user_index < 3; ++user_index) {
			int number = Integer.parseInt(userNumbersList.get(user_index));
			countBall(number);
			countStrike(number, user_index);
		}
	}

	private void countBall(int number) {
		if (computersDifferentThreeNumbers.contains(number)) {
			ball += 1;
		}
	}

	public void countStrike(int number, int index) {
		if (computersDifferentThreeNumbers.contains(number)
				&& index == computersDifferentThreeNumbers.indexOf(number)) {
			strike += 1;
			ball -= 1;
		}
	}

	public void resetBallAndStrike() {
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
