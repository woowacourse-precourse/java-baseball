package baseball.domain;

import java.util.List;

public class BallsAndStrikesCountCalculator {
	public static int calculateStrikesCount(List<Integer> number, List<Integer> answer) {
		return (int)number.stream()
			.filter(digit -> digit.equals(answer.get(number.indexOf(digit))))
			.count();
	}

	public static int calculateBallsCount(List<Integer> number, List<Integer> answer) {
		return (int)number.stream()
			.filter(digit -> !digit.equals(answer.get(number.indexOf(digit))))
			.filter(answer::contains)
			.count();
	}
}
