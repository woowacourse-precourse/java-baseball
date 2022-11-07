package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

class Match {
	private Computer computer;
	private User user;

	public Match(Computer computer, User user) {
		this.computer = computer;
		this.user = user;
	}

	public int getStrike() {
		List<Integer> computerNumbers = computer.getNumbers();
		List<Integer> userNumbers = user.getNumbers();
		int strikeNumbers = 0;

		for (int i = 0; i < 3; i++) {
			if (computerNumbers.get(i).equals(userNumbers.get(i))) strikeNumbers += 1;
		}
		return strikeNumbers;
	}

	public int getBall() {
		List<Integer> computerNumbers = computer.getNumbers();
		List<Integer> userNumbers = user.getNumbers();
		int ballNumber = 0;

		for (int i = 0; i < 3; i++) {
			if (computerNumbers.contains(userNumbers.get(i))) ballNumber += 1;
		}
		return ballNumber;
	}

	public int play() throws IllegalArgumentException {
		int strike = getStrike();
		int ball = getBall() - strike;
		int restartOrEnd = 0;

		if (strike == 3) {
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다!게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			restartOrEnd = Integer.parseInt(Console.readLine());

			if (restartOrEnd != 1 && restartOrEnd != 2) throw new IllegalArgumentException("숫자 1 혹은 2만 입력해주세요");
		} else if (strike > 0 || ball > 0) {
			if (strike == 0) {
				System.out.println(ball + "볼");
			} else if (ball == 0) {
				System.out.println(strike + "스트라이크");
			} else {
				System.out.println(ball + "볼 " + strike + "스트라이크");
			}
		} else {
			System.out.println("낫싱");
		}
		return restartOrEnd;
	}

}
