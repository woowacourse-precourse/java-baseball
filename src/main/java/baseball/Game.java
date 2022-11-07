package baseball;

import java.util.ArrayList;
import java.util.HashSet;

class Game {
	static int strike = 0;
	static int ball = 0;
	static HashSet<Integer> strikeSet;

	static void gameStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	static void getNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		Player.writeNumber();
		changeStringToList();
	}

	private static void changeStringToList() {
		Player.numberList = new ArrayList<>();

		checkInput();
		while (Player.number > 0) {
			Player.numberList.add(0, Player.number % 10);
			Player.number /= 10;
		}
		if (checkSameNumber())
			throw new IllegalArgumentException("same value");
	}

	private static void checkInput() {
		try {
			Player.number = Integer.parseInt(Player.numberString);
		} catch (IllegalArgumentException exception) {
			throw new IllegalArgumentException("wrong Input");
		}

		if (!Application.getAnswer && Player.numberString.length() != 3)
			throw new IllegalArgumentException("wrong size");

		if (Application.getAnswer && !(Player.number == 1 || Player.number == 2))
			throw new IllegalArgumentException("wrong value");
	}

	private static boolean checkSameNumber() {
		if (Player.numberList.get(0) == Player.numberList.get(1) ||
				Player.numberList.get(0) == Player.numberList.get(2) ||
				Player.numberList.get(1) == Player.numberList.get(2))
			return true;
		return false;
	}


	static void getScore() {
		checkStrike();
		checkBall();
	}

	static void checkStrike() {
		strikeSet = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			if (Computer.numberList.get(i) == Player.numberList.get(i)) {
				strike++;
				strikeSet.add(i);
			}
		}
	}

	static void checkBall() {
		for (int i = 0; i < 3; i++) {
			if (strikeSet.contains(i))
				continue;
			addBall(i);
		}
	}

	static void addBall(int i) {
		for (int j = 0; j < 3; j++) {
			if (Computer.numberList.get(i) == Player.numberList.get(j)) {
				ball++;
				break;
			}
		}
	}

	static void printResult() {
		if (strike == 3) {
			Application.getAnswer = true;
			System.out.println("3스트라이크");
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		}
		if (ball > 0)
			System.out.print(ball + "볼 ");
		if (!Application.getAnswer && strike > 0)
			System.out.print(strike + "스트라이크");
		if (ball == 0 && strike == 0)
			System.out.print("낫싱");
		System.out.println();
	}

	static void whenFinish() {
		Player.writeNumber();
		checkInput();
	}
}