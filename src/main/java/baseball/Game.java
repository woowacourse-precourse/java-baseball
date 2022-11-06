package baseball;

public class Game {
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

		while(strike < 3) {
			compare();
		}

		System.out.println(MESSAGE_RETRY);
		retryOrNot();
	}

	public void compare() {
		user.scanInputByStatus(status.getStatus());

		for(int index = 0; index < 3; index++) {
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
		}
		if (strike != 0 && ball != 0) {
			System.out.println(ball + MESSAGE_BALL + MESSAGE_BLANK + strike + MESSAGE_STRIKE);
		}
	}
}
