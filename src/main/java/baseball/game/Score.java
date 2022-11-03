package baseball.game;

import java.util.List;
import java.util.Objects;

public class Score {
	private int strike;
	private int ball;

	private Score(List<Integer> computerNumbers, List<Integer> userNumbers) {
		calculateScore(computerNumbers, userNumbers);
	}

	public static Score calculate(List<Integer> computerNumbers, List<Integer> userNumbers) {
		return new Score(computerNumbers, userNumbers);
	}

	private void calculateScore(List<Integer> computerNumbers, List<Integer> userNumbers) {
		for (int i = 0; i < 3; i++) {
			calculateBall(computerNumbers.get(i), userNumbers);
			if (Objects.equals(computerNumbers.get(i), userNumbers.get(i))) {
				strike++;
				ball--;
			}
		}
	}

	private void calculateBall(Integer computerNumber, List<Integer> userNumbers) {
		for (int i = 0; i < 3; i++) {
			if (Objects.equals(computerNumber, userNumbers.get(i))) {
				ball++;
			}
		}
	}
}
