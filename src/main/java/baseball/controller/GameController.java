package baseball.controller;

import java.util.List;

import baseball.constant.GameConstants;
import baseball.domain.Comparator;
import baseball.utils.Converter;
import baseball.utils.RandomNumberGenerator;
import baseball.utils.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private final List<Integer> answer = RandomNumberGenerator.generateRandomNumber();
	private final Comparator comparator = new Comparator(answer);

	public void control() {
		InputView inputView = new InputView();
		do {
			String number = inputView.getNumberFromUser();
			Validator.validateNumberInput(number);
			List<Integer> digits = Converter.convertStringToIntegerList(number);
			comparator.compare(digits);
		} while (!comparator.isCorrect());
		OutputView.printGettingRightAnswerMessage(GameConstants.LENGTH_OF_NUMBER);
	}
}
