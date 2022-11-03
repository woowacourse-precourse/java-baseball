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
		computer.generateComputerNumbers();
		user.receiveUserInput();

		List<Integer> computerNumbers = computer.getNumbers();
		List<Integer> userNumbers = user.getNumbers();

		int strike = 0;
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Objects.equals(computerNumbers.get(i), userNumbers.get(j))) {
					ball++;
				}
			}
			if (Objects.equals(computerNumbers.get(i), userNumbers.get(i))) {
				strike++;
				ball--;
			}
		}
	}
}
