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

	public void control() {
		init();
		play();
		finishGame();
	}

	public boolean hasRestartRequest() {
		String request = inputView.getRestartRequest();
		Validator.validateRestartOrNotInput(request);
		return request.equals(GameConstants.RESTART_GAME);
	}

	private void init() {
		final List<Integer> answer = RandomNumberGenerator.generate();
		numberComparator = new NumberComparator(answer);
	}

	private void play() {
		do {
			numberComparator.compare(getDigits());
			outputView.printResult(numberComparator.getBallsCount(), numberComparator.getStrikesCount());
		} while (!numberComparator.hasCorrectNumber());
	}

	private List<Integer> getDigits() {
		String number = inputView.getNumberFromUser();
		Validator.validateNumberInput(number);
		return Converter.convertStringToIntegerList(number);
	}

	private void finishGame() {
		outputView.printFinishingGameMessage(GameConstants.LENGTH_OF_NUMBER);
	}
}
