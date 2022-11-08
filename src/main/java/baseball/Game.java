package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private static final int COUNT_NUMBER = 3;

	private static final String NEW_GAME = "1";
	private static final String END_GAME = "2";
	private static final String STRIKE_WORD = "스트라이크";
	private static final String BALL_WORD = "볼";
	private static final String NOT_MATCH_WORD = "낫싱";
	private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

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

			resetScore();
			score();
			printResult();

			if (strike == COUNT_NUMBER) {
				ExitOrRestart(computerNumber);
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

	private void resetScore() {
		strike = 0;
		ball = 0;
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
		return NOT_MATCH_WORD;
	}

	private void printResult() {
		System.out.println(getResult());
		if (strike == COUNT_NUMBER) {
			System.out.println(THREE_STRIKE_MESSAGE);
		}
	}
	
	private String getResult() {
		String result = "";
		if (strike == 0 && ball == 0) {
			result += NOT_MATCH_WORD;
		}
		if (ball != 0) {
			result += this.ball + BALL_WORD;
		}
		if (strike != 0) {
			if (this.ball != 0) {
				result += " ";
			}
			result += this.strike + STRIKE_WORD;
		}
		
		return result;
	}
	
	private void ExitOrRestart(Number computerNumber) {
		String input = inputExit();
		if (END_GAME.equals(input)) {
			exit = true;
		} else {
			computerNumber.setRandomNumber();
			computer = computerNumber.getNumber();
		}
	}
	
	private String inputExit() {
		System.out.println(END_MESSAGE);
		String input = Console.readLine();
		if(!checkInput(input)) {
			throw new IllegalArgumentException();
		}
		return input;
	}
	
	private boolean checkInput(String input) {
		return input.equals(NEW_GAME) || input.equals(END_GAME);
	}
}