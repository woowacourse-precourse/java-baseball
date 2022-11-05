package Controller;

import static Controller.Guess.*;
import static Controller.Printer.*;

import java.util.List;

import computer.RandomNumberGenerator;

public class Game {
	public void play() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		List<Integer> answer = randomNumberGenerator.generateRandomNumber();
		printGameStartMessage();

		while (true) {
			if (guess(answer)) {
				break;
			}
		}
	}

}
