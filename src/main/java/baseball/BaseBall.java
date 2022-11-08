package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Random;

public class BaseBall {
	private int[] goalArr;
	private int[] goalUsageArr;
	private int[] ballArr;

	private boolean[] isStrike;
	private int numBall;
	private int numStrike;

	private StringBuilder sb;

	public BaseBall() {
		goalArr = new int[Constants.NUM_DIGIT];
		goalUsageArr = new int[Constants.NUM_BOUNDARY];
		ballArr = new int[Constants.NUM_DIGIT];
	}

	public void game() {
		gameInit();
		gameRunLoop();
	}

	private void gameInit() {
		printOpeningStatus();
	}

	private void printOpeningStatus() {
		System.out.println(Constants.OPENING_STATUS);
	}

	private void gameRunLoop() {
		while (Constants.PLAYING) {
			if (gameRun()) {
				break;
			}
		}
	}

	private boolean gameRun() {
		gamePrepare();
		gamePlayLoop();
		return newGameCheck();
	}

	private void gamePrepare() {
		goalArr = new int[Constants.NUM_DIGIT];
		goalUsageArr = new int[Constants.NUM_BOUNDARY];
		ballArr = new int[Constants.NUM_DIGIT];
		makeGoal();
	}

	private void makeGoal() {
		for (int idx = 0; idx < Constants.NUM_DIGIT; idx++) {
			int randomNum = makeNumber();
			makeNumberOrder(this.goalArr, randomNum, idx);
			makeNumberUsage(this.goalUsageArr, randomNum);
		}
	}

	private int makeNumber() {
		int number = Randoms.pickNumberInRange(1, 9);
		while (this.goalUsageArr[number] != 0) {
			number = Randoms.pickNumberInRange(1, 9);
		}
		return number;
	}

	private void makeNumberOrder(int[] arr, int num, int idx) {
		arr[idx] = num;
	}

	private void makeNumberUsage(int[] arr, int num) {
		arr[num] += 1;
	}

	private void gamePlayLoop() {
		while (Constants.PLAYING) {
			if (gamePlay()) {
				break;
			}
		}
	}

	private boolean gamePlay() {
		Ready();
		play();
		return nextAction();
	}

	private void Ready() {
		String ball = inputBall();
		if (verifyBall(ball)) {
			makeBall(ball);
		} else {
			illegalArgumentException();
		}
	}

	private void illegalArgumentException() {
		throw new IllegalArgumentException();
	}

	private String inputBall() {
		printSetBallStatus();
		return setBall();
	}

	private void printSetBallStatus() {
		System.out.print(Constants.SET_BALL_STATUS);
	}

	private String setBall() {
		return readLine();
	}

	private String readLine() {
		return camp.nextstep.edu.missionutils.Console.readLine();
	}

	private boolean verifyBall(String ball) {
		if (!verifyLength(ball) || !verifyIsNumber(ball) || !verifyDupNumber(ball)) {
			return Constants.NOT_VERIFY;
		} else {
			return Constants.VERIFY;
		}
	}

	private boolean verifyLength(String ball) {
		if (ball.length() > Constants.NUM_DIGIT) {
			return Constants.NOT_VERIFY;
		} else {
			return Constants.VERIFY;
		}
	}

	private boolean verifyIsNumber(String ball) {
		try {
			int number = Integer.parseInt(ball);
			return Constants.VERIFY;
		} catch (NumberFormatException e) {
			return Constants.NOT_VERIFY;
		}
	}

	private boolean verifyDupNumber(String ball) {
		int ballNumber = Integer.parseInt(ball);
		int[] verifyDup = new int[Constants.NUM_BOUNDARY];

		int pow = 0;
		while (ballNumber >= Math.pow(10, pow)) {
			int digit = digitNumber(ballNumber, pow);

			if (verifyDup[digit] != 0) {
				return Constants.NOT_VERIFY;
			}

			verifyDup[digit] += 1;
			pow += 1;
		}

		return Constants.VERIFY;
	}

	private void makeBall(String ball) {
		int ballNumber = Integer.parseInt(ball);

		int pow = 0;
		while (ballNumber >= Math.pow(10, pow)) {
			int digit = digitNumber(ballNumber, pow);

			makeNumberOrder(this.ballArr, digit, pow);
			pow += 1;
		}
	}

	private int digitNumber(int number, int pow) {
		return number % (int)Math.pow(10, pow + 1) / (int)Math.pow(10, pow);
	}

	private void play() {
		checkStrike();
		checkBall();
		printPlayStatus();
	}

	private void checkStrike() {
		isStrike = new boolean[Constants.NUM_DIGIT];
		numStrike = 0;

		for (int idx = 0; idx < Constants.NUM_DIGIT; idx++) {
			if (goalArr[idx] == ballArr[idx]) {
				isStrike[idx] = true;
				numStrike += 1;
			}
		}
	}

	private void checkBall() {
		numBall = 0;

		for (int idx = 0; idx < Constants.NUM_DIGIT; idx++) {
			if (isStrike[idx]) {
				continue;
			}

			if (goalUsageArr[ballArr[idx]] != 0) {
				numBall += 1;
			}
		}
	}

	private void printPlayStatus() {
		sb = new StringBuilder();
		if (numBall > 0) {
			sb.append(numBall).append(Constants.BALL);
		}
		if (sb.length() > 0) {
			sb.append(Constants.SPACE);
		}
		if (numStrike > 0) {
			sb.append(numStrike).append(Constants.STRIKE);
		}
		if (sb.length() == 0) {
			sb.append(Constants.NOTHING);
		}

		System.out.println(sb.toString());
	}

	private boolean nextAction() {
		if (isCompleteGoal()) {
			printCelebrateStatus();
			return Constants.GAME_END;
		} else {
			return Constants.GAME_CONTINUE;
		}
	}

	private boolean isCompleteGoal() {
		if (numStrike == Constants.NUM_DIGIT) {
			return Constants.GAME_END;
		} else {
			return Constants.GAME_CONTINUE;
		}
	}

	private void printCelebrateStatus() {
		System.out.println(Constants.CELEBRATE_MESSAGE);
	}

	private boolean newGameCheck() {
		String order = confirmNextAction();

		if (!verifyOrder(order)) {
			illegalArgumentException();
		}

		if (order.equals(Constants.ORDER_NEW_GAME)) {
			return Constants.GAME_START;
		} else{
			return Constants.GAME_EXIT;
		}
	}

	private String confirmNextAction() {
		printNewGameStatus();
		return readLine();
	}

	private void printNewGameStatus() {
		System.out.println(Constants.NEW_GAME_MESSAGE);
	}

	private boolean verifyOrder(String order) {
		if (order.equals(Constants.ORDER_NEW_GAME) || order.equals(Constants.ORDER_GAME_EXIT)) {
			return Constants.VERIFY;
		} else {
			return Constants.NOT_VERIFY;
		}
	}
}
