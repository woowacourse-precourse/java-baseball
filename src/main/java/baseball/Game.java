package baseball;

public class Game {
	private static final int MAX_STRIKE = 3;
	private static final int INIT_STRIKE_AND_BALL = 0;
	private static final int END_OR_RESTART_INPUT_LENGTH = 1;
	private static final int NUMBERS_INPUT_LENGTH = 3;
	private static final String END_NUMBER = "2";
	private static int strike;
	private static int ball;

	public void gameStart(Computer computer, Player player, Checker checker) {
		View.startGameGuideMessage();
		boolean end;

		do {
			game(computer, player, checker);

			String userInputEnd = player.inputEndOrRe();
			checker.userInputChecker(userInputEnd, END_OR_RESTART_INPUT_LENGTH, player);
			end = isEndGame(userInputEnd);
			isReStart(computer, !end);

		} while (!end);
	}

	private void game(Computer computer, Player player, Checker checker) {

		do {
			initBallAndStrike();

			String userInput = player.inputNumber();
			checker.userInputChecker(userInput, NUMBERS_INPUT_LENGTH, player);
			player.makeUserNumber(userInput);

			calculateStrikeAndBall(computer, player);
			View.printResult(ball, strike, INIT_STRIKE_AND_BALL);
		} while (strike != MAX_STRIKE);

		View.showThreeStrike();
	}

	private boolean isEndGame(String userInputEnd) {
		if (userInputEnd.equals(END_NUMBER)) {
			return true;
		}
		return false;
	}

	private static void isReStart(Computer computer, boolean reStart) {
		if (reStart) {
			computer.makeRandomNumber();
		}
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
}
