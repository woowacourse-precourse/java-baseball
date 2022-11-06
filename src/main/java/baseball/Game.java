package baseball;

public class Game {
	static final String MESSAGE_INPUT = "숫자를 입력해주세요 : ";
	static final String MESSAGE_START = "숫자 야구 게임을 시작합니다.";
	static final String MESSAGE_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	static final String MESSAGE_NOTHING = "낫싱";
	static final String MESSAGE_BALL = "볼";
	static final String MESSAGE_BLANK = " ";
	static final String MESSAGE_STRIKE = "스트라이크";
	static final String MESSAGE_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	static final int MAX_STRIKE = 3;
	static final int MIN_LIST_INDEX = 0;
	static final int MAX_LIST_INDEX = 3;

	Computer computer;
	Status status;
	User user;

	int strike = 0;
	int ball = 0;

	Game(Computer computer, Status status, User user) {
		this.computer = computer;
		this.status = status;
		this.user = user;
	}

	public void gameStart() {
		System.out.println(MESSAGE_START);
		status.setStatusPlaying();

		while(strike < MAX_STRIKE) {
			compare();
		}

		System.out.println(MESSAGE_RETRY);
		retryOrNot();
	}

	public void compare() {
		System.out.print(MESSAGE_INPUT);
		user.scanInputByStatus(status.getStatus());

		for(int index = MIN_LIST_INDEX; index < MAX_STRIKE; index++) {
			if(computer.getComputersList().contains(user.validatedUserInput.get(index))) {
				ball++;
			}
			if(computer.getComputersList().get(index).equals(user.validatedUserInput.get(index))) {
				ball--;
				strike++;
			}
		}

		printMessages();
	}

	public void printMessages() {
		if (strike == 0 && ball == 0) {
			System.out.println(MESSAGE_NOTHING);
		}
		if (strike == 0 && ball != 0) {
			System.out.println(ball + MESSAGE_BALL);
		}
		if (strike != 0 && ball == 0) {
			System.out.println(strike + MESSAGE_STRIKE);
			System.out.println(MESSAGE_GAME_OVER);
		}
		if (strike != 0 && ball != 0) {
			System.out.println(ball + MESSAGE_BALL + MESSAGE_BLANK + strike + MESSAGE_STRIKE);
		}
	}

	public void retryOrNot() {
		System.out.println(MESSAGE_RETRY);
		status.setStatusTerminating();
		user.scanInputByStatus(status.getStatus());

		if(user.getValidatedUserInput().get(0).equals(1)) {
			gameStart();
		}
	}
}
