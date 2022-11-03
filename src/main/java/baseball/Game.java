package baseball;

public class Game {
	private static final int MAX_STRIKE = 3;
	private static final int INIT_STRIKE_AND_BALL = 0;
	private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String BALL = "볼 ";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";
	private int strike;
	private int ball;

	public void gameStart(Computer computer, Player player) {
		computer.makeRandomNumber();

		do {
			initBallAndStrike();

			player.makeUserNumber();
			calculateStrikeAndBall(computer, player);

			printResult();

		} while (true);
	}

	private void initBallAndStrike() {
		this.ball = INIT_STRIKE_AND_BALL;
		this.strike = INIT_STRIKE_AND_BALL;
	}

	private void calculateStrikeAndBall(Computer computer, Player player) {
		int computerNumberIndex = 0;

		for (Integer userNumber : player.getUserNumberList()) {

			if (computer.getRandomNumberValue(computerNumberIndex) == userNumber) {
				strike++;
			} else if (player.getUserNumberList().contains(computer.getRandomNumberValue(computerNumberIndex))) {
				ball++;
			}

			computerNumberIndex++;
		}
	}

	private void showThreeStrike() {
		System.out.println(THREE_STRIKE_MESSAGE);
	}

	private void printResult() {
		String result = "";

		if (ball != INIT_STRIKE_AND_BALL) {
			result += ball + BALL;
		}
		if (strike != INIT_STRIKE_AND_BALL) {
			result += strike + STRIKE;
		}
		if (ball == INIT_STRIKE_AND_BALL && strike == INIT_STRIKE_AND_BALL) {
			result += NOTHING;
		}

		System.out.println(result);
	}
}
