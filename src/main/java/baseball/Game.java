package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Game {
	static final int SIZE = Application.SIZE;
	static final int NEW_GAME = Application.NEW_GAME;
	static final int FINISH_GAME = Application.FINISH_GAME;

	static int strike = 0;
	static int ball = 0;
	static HashSet<Integer> strikeSet;

	static boolean game_flag = false;
	static boolean getAnswer = false;

	static final int START = 7;
	static final int GET_NUMBER = 8;
	static final int RESULT = 9;


	static void runGame() {
		printMessage(START);
		while (true) {
			getAnswer = false;
			if (!game_flag) {
				Computer.getThreeRandomNumber();
				game_flag = true;
			}
			while (!getAnswer) {
				initResult();
				getNumber();
				getScore();
				printMessage(RESULT);
			}
			Game.whenFinish();
			if (Player.number == FINISH_GAME)
				return;
			game_flag = false;
		}
	}

	static void printMessage(int status) {
		if (status == START)
			System.out.println("숫자 야구 게임을 시작합니다.");
		if (status == GET_NUMBER)
			System.out.print("숫자를 입력해주세요 : ");
		if (status == RESULT)
			printResult();
	}

	static void printResult() {
		if (strike == SIZE) {
			getAnswer = true;
			System.out.println(SIZE + "스트라이크");
			System.out.println(SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.print("게임을 새로 시작하려면 " + NEW_GAME + ", 종료하려면 " + FINISH_GAME + "를 입력하세요.");
		}
		if (ball > 0)
			System.out.print(ball + "볼 ");
		if (!getAnswer && strike > 0)
			System.out.print(strike + "스트라이크");
		if (ball == 0 && strike == 0)
			System.out.print("낫싱");
		System.out.println();
	}

	static void initResult() {
		ball = 0;
		strike = 0;
	}

	static void getNumber() {
		printMessage(GET_NUMBER);
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
		if (!getAnswer && Player.numberString.length() != SIZE)
			throw new IllegalArgumentException("wrong size");

		if (getAnswer && !(Player.number == NEW_GAME || Player.number == FINISH_GAME))
			throw new IllegalArgumentException("wrong value");
	}

	private static boolean checkSameNumber() {
		List<Integer> usedNumber = new ArrayList<>();

		for (int num : Player.numberList){
			if (usedNumber.contains(num))
				return true;
			usedNumber.add(num);
		}
		return false;
	}


	static void getScore() {
		checkStrike();
		checkBall();
	}

	private static void checkStrike() {
		strikeSet = new HashSet<>();

		for (int i = 0; i < SIZE; i++) {
			if (Computer.numberList.get(i) == Player.numberList.get(i)) {
				strike++;
				strikeSet.add(i);
			}
		}
	}

	private static void checkBall() {
		for (int i = 0; i < SIZE; i++) {
			if (strikeSet.contains(i))
				continue;
			addBall(i);
		}
	}

	private static void addBall(int i) {
		for (int j = 0; j < SIZE; j++) {
			if (Computer.numberList.get(i) == Player.numberList.get(j)) {
				ball++;
				break;
			}
		}
	}

	static void whenFinish() {
		Player.writeNumber();
		checkInput();
	}
}