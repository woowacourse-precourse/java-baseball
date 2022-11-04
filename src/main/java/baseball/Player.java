package baseball;

import java.util.List;

public class Player {
	private List<Integer> numbers;
	private int strike = 0;
	private int ball = 0;

	public Player(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public void addStrike() {
		this.strike++;
	}

	public void addBall() {
		this.ball++;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
