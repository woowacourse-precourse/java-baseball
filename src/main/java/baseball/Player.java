package baseball;

import java.util.List;

public class Player {
	List<Integer> numbers;
	int strike = 0;
	int ball = 0;

	public Player(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public void addStrike() {
		this.strike++;
	}

	public void addBall() {
		this.ball++;
	}

	public void removeBall() {
		this.ball--;
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
