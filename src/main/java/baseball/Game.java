package baseball;

public class Game {
	private static final int COUNT_NUMBER = 3;
	private static final int NEW_GAME = 1;
	private static final int END_GAME = 2;

	private static final String STRIKE_WORD = "스트라이크";
	private static final String BALL_WORD = "볼";
	private static final String NOT_MATCH_WORD = "낫싱";

	private int[] computer;
	private int[] player;
	private boolean exit = false;

	private int strike = 0;
	private int ball = 0;

	public void start() {
		Number playerNumber = new Number();
		Number computerNumber = new Number();

		computerNumber.setRandomNumber();
		computer = computerNumber.getNumber();

		while (!exit) {
			playerNumber.getAnswer();
			player = playerNumber.getNumber();

			if (strike == COUNT_NUMBER) {

			}
		}
	}

	private void score() {
		for (int i = 0; i < COUNT_NUMBER; i++) {
			String score = StrikeOrBall(player[i], i);
			if (score == STRIKE_WORD) {
				ball++;
				continue;
			}
			if (score == BALL_WORD) {
				strike++;
			}

		}
	}

	private String StrikeOrBall(int num, int index) {
		for (int i = 0; i < COUNT_NUMBER; i++) {
			if (computer[i] == num && i == index) {
				return STRIKE_WORD;
			}
			if (computer[i] == num) {
				return BALL_WORD;
			}
		}
		return null;
	}
}
