package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private User user;
	private Computer computer;
	private Score score;

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
		score = Score.calculate(computer.getNumbers(), user.getNumbers());

		while (true) {
			if (score.isWin()) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
				String input = Console.readLine();
				if (input.equals("1")) {
					computer.generateNumbers();
					score.invalidate();
					continue;
				} else if (input.equals("2")) {
					break;
				} else {
					throw new IllegalArgumentException("1또는 2만 입력해주세요.");
				}
			}
			user.receiveUserInput();
			score = Score.calculate(computer.getNumbers(), user.getNumbers());
		}
	}
}
