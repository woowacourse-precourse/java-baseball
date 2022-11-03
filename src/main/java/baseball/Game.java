package baseball;

public class Game {
	private static final int MAX_STRIKE = 3;
	private static final int INIT_STRIKE_AND_BALL = 0;
	private static final int END_OR_RESTART_INPUT_LENGTH = 1;
	private static final int NUMBERS_INPUT_LENGTH = 0;
	private static final String END_NUMBER = "2";
	private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String BALL = "볼 ";
	private static final String STRIKE = "스트라이크";
	private static final String NOTHING = "낫싱";
	private static int strike;
	private static int ball;

	public void gameStart(Computer computer, Player player, Checker checker) {
		System.out.println("숫자 야구 게임을 시작합니다.");
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
			printResult();
		} while (strike != MAX_STRIKE);

		showThreeStrike();
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
