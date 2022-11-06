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
}
