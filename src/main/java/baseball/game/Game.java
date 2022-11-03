package baseball.game;

public class Game {
	private User user;
	private Computer computer;

	private Game(Computer computer, User user) {
		System.out.println("숫자 야구 게임을 시작합니다.");
		this.computer = computer;
		this.user = user;
	}

	public static Game create() {
		return new Game(new Computer(), new User());
	}

	public void start() {
		computer.generateComputerNumbers();
		user.receiveUserInput();
	}
}
