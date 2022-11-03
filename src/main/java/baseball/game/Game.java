package baseball.game;

import java.util.List;
import java.util.Objects;

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
		computer.generateNumbers();
		user.receiveUserInput();
		Score score = Score.calculate(computer.getNumbers(), user.getNumbers());
	}
}
