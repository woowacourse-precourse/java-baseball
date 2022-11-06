package baseball.controller;

import java.util.List;

import baseball.constant.GameConstants;
import baseball.domain.NumberComparator;
import baseball.util.Converter;
import baseball.util.RandomNumberGenerator;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private NumberComparator numberComparator;

	public void start() {
		outputView.printGameStartMessage();
	}

	private void init() {
		final List<Integer> answer = RandomNumberGenerator.generateRandomNumber();
		numberComparator = new NumberComparator(answer);
	}

	public void control() {
		init();
		do {
			String number = inputView.getNumberFromUser();
			Validator.validateNumberInput(number);
			List<Integer> digits = Converter.convertStringToIntegerList(number);
			numberComparator.compare(digits);
			outputView.printResult(numberComparator.getBallsCount(), numberComparator.getStrikesCount());
		} while (!numberComparator.isCorrect());
		outputView.printGettingRightAnswerMessage(GameConstants.LENGTH_OF_NUMBER);
	}

	public boolean askRestart() {
		String request = inputView.getRestartResponse();
		Validator.validateRestartOrNotInput(request);
		return request.equals(GameConstants.RESTART_GAME);
	}
}
