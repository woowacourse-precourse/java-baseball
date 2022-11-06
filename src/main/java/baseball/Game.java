package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private static final String MESSAGE_INPUT = "숫자를 입력해주세요 : ";
	private static final String MESSAGE_START = "숫자 야구 게임을 시작합니다.";
	private static final String MESSAGE_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	private static final String MESSAGE_NOTHING = "낫싱";
	private static final String MESSAGE_BALL = "볼";
	private static final String MESSAGE_BLANK = " ";
	private static final String MESSAGE_STRIKE = "스트라이크";
	private static final String MESSAGE_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	private static final int ZERO = 0;
	private static final int MAX_STRIKE = 3;
	private static final int MIN_LIST_INDEX = 0;
	private static final int MAX_LIST_INDEX = 3;
	private static final int RETRY_ANSWER_INDEX = 0;
	private static final int RETRY_CODE = 1;

	private Computer computer;
	private Status status;
	private User user;

	private int strike;
	private int ball;

	Game() {
		computer = new Computer();
		status = new Status();
		user = new User();
	}

	public void gameStart() {
		initGame();

		while(strike < MAX_STRIKE) {
			compare();
		}

		retryOrNot();
	}

	private void compare() {
		initCounts();
		requestInput();

		for(int index = MIN_LIST_INDEX; index < MAX_LIST_INDEX; index++) {
			if(computer.getComputersList().contains(user.getValidatedUserInput().get(index))) {
				ball++;
			}
			if(computer.getComputersList().get(index).equals(user.getValidatedUserInput().get(index))) {
				ball--;
				strike++;
			}
		}

		printMessages();
	}

	private void printMessages() {
		if (strike == ZERO && ball == ZERO) {
			System.out.println(MESSAGE_NOTHING);
		}
		if (strike == ZERO && ball != ZERO) {
			System.out.println(ball + MESSAGE_BALL);
		}
		if (strike != ZERO && ball == ZERO) {
			System.out.println(strike + MESSAGE_STRIKE);
		}
		if (strike != ZERO && ball != ZERO) {
			System.out.println(ball + MESSAGE_BALL + MESSAGE_BLANK + strike + MESSAGE_STRIKE);
		}
	}

	private void retryOrNot() {
		System.out.println(MESSAGE_GAME_OVER);
		System.out.println(MESSAGE_RETRY);
		status.setStatusTerminating();
		user.scanInputByStatus(status.getStatus());

		if(user.getValidatedUserInput().get(RETRY_ANSWER_INDEX).equals(RETRY_CODE)) {
			gameStart();
		}
	}

	private void initGame() {
		initCounts();
		System.out.println(MESSAGE_START);
		computer.setComputersList();
		status.setStatusPlaying();
	}

	private void initCounts() {
		ball = ZERO;
		strike = ZERO;
	}

	private void requestInput() {
		System.out.print(MESSAGE_INPUT);
		user.scanInputByStatus(status.getStatus());
	}
}
