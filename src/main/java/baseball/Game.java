package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Game {
	private final int SIZE;
	private final int NEW_GAME;
	private final int FINISH_GAME;

	int strike = 0;
	int ball = 0;
	HashSet<Integer> strikeSet;

	boolean game_flag = false;
	boolean getAnswer = false;

	final int START = 7;
	final int GET_NUMBER = 8;
	final int RESULT = 9;

	Computer computer;
	Game(final int SIZE, final int NEW_GAME, final int FINISH_GAME) {
		this.SIZE = SIZE;
		this.NEW_GAME = NEW_GAME;
		this.FINISH_GAME = FINISH_GAME;
		computer = new Computer(SIZE);
	}

	void start() {

		printMessage(START);
		while (true) {
			getAnswer = false;
			if (!game_flag) {
				computer.getThreeRandomNumber();
				game_flag = true;
			}
			while (!getAnswer) {
				initResult();
				getNumber();
				getScore();
				printMessage(RESULT);
			}
			whenFinish();
			if (Player.number == FINISH_GAME)
				return;
			game_flag = false;
		}
	}

	void printMessage(int status) {
		if (status == START)
			System.out.println("숫자 야구 게임을 시작합니다.");
		if (status == GET_NUMBER)
			System.out.print("숫자를 입력해주세요 : ");
		if (status == RESULT)
			printResult();
	}

	void printResult() {
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

	void initResult() {
		ball = 0;
		strike = 0;
	}

	void getNumber() {
		printMessage(GET_NUMBER);
		Player.writeNumber();
		changeStringToList();
	}

	private void changeStringToList() {
		Player.numberList = new ArrayList<>();

		checkInput();
		while (Player.number > 0) {
			Player.numberList.add(0, Player.number % 10);
			Player.number /= 10;
		}
		if (checkSameNumber())
			throw new IllegalArgumentException("same value");
	}

	private void checkInput() {
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

	private boolean checkSameNumber() {
		List<Integer> usedNumber = new ArrayList<>();

		for (int num : Player.numberList) {
			if (usedNumber.contains(num))
				return true;
			usedNumber.add(num);
		}
		return false;
	}


	void getScore() {
		checkStrike();
		checkBall();
	}

	private void checkStrike() {
		strikeSet = new HashSet<>();

		for (int i = 0; i < SIZE; i++) {
			if (computer.numberList.get(i) == Player.numberList.get(i)) {
				strike++;
				strikeSet.add(i);
			}
		}
	}

	private void checkBall() {
		for (int i = 0; i < SIZE; i++) {
			if (strikeSet.contains(i))
				continue;
			addBall(i);
		}
	}

	private void addBall(int i) {
		for (int j = 0; j < SIZE; j++) {
			if (computer.numberList.get(i) == Player.numberList.get(j)) {
				ball++;
				break;
			}
		}
	}

	void whenFinish() {
		Player.writeNumber();
		checkInput();
	}
}