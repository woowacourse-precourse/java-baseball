package baseball.domain;

import java.util.List;

import baseball.constant.GameConstants;

public class NumberComparator {
	private final List<Integer> answer;
	private boolean isCorrect = false;
	private int ballsCount;
	private int strikesCount;

	public NumberComparator(List<Integer> answer) {
		this.answer = answer;
	}

	private int calculateStrikesCount(List<Integer> number) {
		return (int)number.stream()
			.filter(digit -> digit.equals(answer.get(number.indexOf(digit))))
			.count();
	}

	private int calculateBallsCount(List<Integer> number) {
		return (int)number.stream()
			.filter(digit -> !digit.equals(answer.get(number.indexOf(digit))))
			.filter(answer::contains)
			.count();
	}

	public void compare(List<Integer> digits) {
		ballsCount = calculateBallsCount(digits);
		strikesCount = calculateStrikesCount(digits);

		if (strikesCount == GameConstants.LENGTH_OF_NUMBER) {
			isCorrect = true;
		}
	}

	public int getBallsCount() {
		return ballsCount;
	}

	public int getStrikesCount() {
		return strikesCount;
	}

	public boolean hasCorrectNumber() {
		return isCorrect;
	}
}
