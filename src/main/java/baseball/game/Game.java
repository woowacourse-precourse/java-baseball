package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private final User user;
	private final Computer computer;
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
		init();
		loop();
	}

	private void init() {
		computer.generateNumbers();
		user.receiveUserInput();
		score = Score.calculate(computer.getNumbers(), user.getNumbers());
	}

	private void loop() {
		while (true) {
			if (isGameOver()) {
				return;
			}
			user.receiveUserInput();
			score = Score.calculate(computer.getNumbers(), user.getNumbers());
		}
	}

	private boolean isGameOver() {
		if (score.isWin()) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			return !restartOrExit();
		}
		return false;
	}

	private boolean restartOrExit() {
		String input = Console.readLine();
		if (input.equals("1")) {
			computer.generateNumbers();
			score.invalidate();
			return true;
		}
		if (input.equals("2")) {
			return false;
		}
		throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
	}
}
