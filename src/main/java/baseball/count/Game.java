package baseball.count;

public class Game {
	int strikeCount;
	int ballCount;

	public void gameSetting() {
		strikeCount = 0;
		ballCount = 0;
	}

	public void strikeAdd() {
		strikeCount += 1;
	}

	public void ballAdd() {
		ballCount += 1;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}