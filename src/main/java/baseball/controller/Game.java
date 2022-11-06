package baseball.controller;

import static baseball.constant.GameConstants.*;
import static baseball.domain.Guess.*;
import static baseball.view.Printer.*;

import java.util.List;

import baseball.utils.RandomNumberGenerator;

public class Game {
	public void play() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		List<Integer> answer = randomNumberGenerator.generateRandomNumber();

		while (true) {
			if (guess(answer)) {
				break;
			}
		}
		printGettingRightAnswerMessage(LENGTH_OF_NUMBER);
	}

}
