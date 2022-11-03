package baseball.game;

import java.util.List;
import java.util.Objects;

public class Score {
	private int strike;
	private int ball;

	private Score(List<Integer> computerNumbers, List<Integer> userNumbers) {
		calculateScore(computerNumbers, userNumbers);
		printResult();
	}

	private void printResult() {
		if (strike > 0 && ball > 0) {
			System.out.printf("%d볼 %d스트라이크%n", ball, strike);
			return;
		}
		if (strike > 0) {
			System.out.printf("%d스트라이크%n", strike);
			return;
		}
		if (ball > 0) {
			System.out.printf("%d볼%n", ball);
			return;
		}
		System.out.println("낫싱");
	}

	public static Score calculate(List<Integer> computerNumbers, List<Integer> userNumbers) {
		return new Score(computerNumbers, userNumbers);
	}

	public void invalidate() {
		this.strike = 0;
		this.ball = 0;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public boolean isWin() {
		return strike == 3;
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
