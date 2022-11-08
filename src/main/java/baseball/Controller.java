package baseball;

import java.util.Scanner;

import baseball.utils.RandomUtils;

public class Controller {
	Scanner scanner = new Scanner(System.in);
	public void run() {
		gameSet();
		gameStart();
		gameEnd();

	}
	private void gameSet() {
		int[] randomNumbers = RandomUtils.getRandomNumbers();
	}

	private void gameStart() {
	}

	private void gameEnd() {

	}

}
