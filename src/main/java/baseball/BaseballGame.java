package baseball;

import static baseball.NumberGenerator.*;

public class BaseballGame {

	private static final String START_GAME_MESSAGE
		= "숫자 야구 게임을 시작합니다.";

	private Balls answer;

	public void play() {
		setUp();
		process();
		askForNewGame();
	}

	private void setUp() {
		System.out.println(START_GAME_MESSAGE);
		answer = new Balls(createNonDuplicateNumbers());
	}

	private void process() {
		while (true) {
			Balls player = new Balls(InputView.getBallNumbers());
			CompareResult result = answer.compareTo(player);
			OutputView.display(result);

			if (result.isGameEnd()) {
				break;
			}
		}
	}

	private void askForNewGame() {
		GameOption option = InputView.getGameOption();

		if (option.isRestart()) {
			play();
		}
	}
}