package baseball.game;

import java.util.List;
import java.util.Objects;

import static baseball.game.Const.*;

public class Score {
	private int strike;
	private int ball;

	private Score(List<Integer> computerNumbers, List<Integer> userNumbers) {
		calculateScore(computerNumbers, userNumbers);
		printResult();
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
		return strike == GAME_LENGTH;
	}

	private void calculateScore(List<Integer> computerNumbers, List<Integer> userNumbers) {
		for (int i = 0; i < GAME_LENGTH; i++) {
			calculateBall(computerNumbers.get(i), userNumbers);
			if (Objects.equals(computerNumbers.get(i), userNumbers.get(i))) {
				strike++;
				ball--;
			}
		}
	}

	private void printResult() {
		if (strike > 0 && ball > 0) {
			System.out.printf(GAME_SCORE_STRIKE_BALL_MESSAGE, ball, strike);
			return;
		}
		if (strike > 0) {
			System.out.printf(GAME_SCORE_STRIKE_MESSAGE, strike);
			return;
		}
		if (ball > 0) {
			System.out.printf(GAME_SCORE_BALL_MESSAGE, ball);
			return;
		}
		System.out.println(GAME_SCORE_NOTHING_MESSAGE);
	}

	private void calculateBall(Integer computerNumber, List<Integer> userNumbers) {
		for (int i = 0; i < GAME_LENGTH; i++) {
			if (Objects.equals(computerNumber, userNumbers.get(i))) {
				ball++;
			}
		}
	}
}
