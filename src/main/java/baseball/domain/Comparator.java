package baseball.domain;

import java.util.List;

import baseball.constant.GameConstants;
import baseball.view.OutputView;

public class Comparator {
	final List<Integer> answer;
	private boolean isCorrect = false;

	public Comparator(List<Integer> answer) {
		this.answer = answer;
	}

	private static int calculateStrikesCount(List<Integer> number, List<Integer> answer) {
		return (int)number.stream()
			.filter(digit -> digit.equals(answer.get(number.indexOf(digit))))
			.count();
	}

	private static int calculateBallsCount(List<Integer> number, List<Integer> answer) {
		return (int)number.stream()
			.filter(digit -> !digit.equals(answer.get(number.indexOf(digit))))
			.filter(answer::contains)
			.count();
	}

	public void compare(List<Integer> digits) {
		int ballsCount = calculateBallsCount(digits, answer);
		int strikesCount = calculateStrikesCount(digits, answer);

		if (strikesCount == GameConstants.LENGTH_OF_NUMBER) {
			isCorrect = true;
		}
		OutputView.printResult(ballsCount, strikesCount);
	}

	public boolean isCorrect() {
		return isCorrect;
	}
}
