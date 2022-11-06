package baseball.domain;

import static baseball.constant.GameConstants.*;

import java.util.List;

import baseball.utils.Converter;
import baseball.view.Printer;
import baseball.utils.Input;
import baseball.utils.Validator;

public class Guess {
	public static boolean guess(List<Integer> answer) {
		Printer.printAskingInputMessage();

		String number = Input.getUserInput();
		Validator.validateNumberInput(number);
		List<Integer> digits = Converter.convertStringToIntegerList(number);

		int ballsCount = BallsAndStrikesCountCalculator.calculateBallsCount(digits, answer);
		int strikesCount = BallsAndStrikesCountCalculator.calculateStrikesCount(digits, answer);
		Printer.printResult(ballsCount, strikesCount);

		return strikesCount == LENGTH_OF_NUMBER;
	}
}
