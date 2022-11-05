package Controller;

import static Controller.Converter.*;
import static Controller.Printer.*;
import static User.Input.*;
import static User.Validator.*;
import static baseball.Constant.*;
import static computer.BallsAndStrikesCountCalculator.*;

import java.util.List;

public class Guess {
	public static boolean guess(List<Integer> answer) {
		printAskingInputMessage();

		String number = getUserInput();
		validateNumberInput(number);
		List<Integer> digits = convertStringToIntegerList(number);

		int ballsCount = calculateBallsCount(digits, answer);
		int strikesCount = calculateStrikesCount(digits, answer);
		printResult(ballsCount, strikesCount);

		return strikesCount == LENGTH_OF_NUMBER;
	}
}
