package baseball.game;

public class Game {
	private static final int MAX_STRIKE_COUNT = 3;
	private final int strikeCount;
	private final int ballCount;

	private GameStatus gameStatus = GameStatus.GAME_CONTINUE;

	private Game(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public static Game from(int strikeCount, int ballCount) {
		return new Game(strikeCount, ballCount);
	}

	public boolean isNothing() {
		return strikeCount == 0 && ballCount == 0;
	}

	public boolean isNoStrike() {
		return strikeCount == 0;
	}

	public boolean isNoBall() {
		return ballCount == 0;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}

	public boolean isGameOver() {
		validateGameStatus();
		return gameStatus.equals(GameStatus.GAME_OVER);
	}

	private void validateGameStatus() {
		if (strikeCount == MAX_STRIKE_COUNT) {
			changeGameStatusToGameOver();
		}
	}

	public void changeGameStatusToGameOver() {
		gameStatus = GameStatus.GAME_OVER;
	}
}
