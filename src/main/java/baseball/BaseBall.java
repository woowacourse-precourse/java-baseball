package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBall {
	public static void start() {
		GameMessage.startGame();
		Balls computer = Balls.createRandom();
		GameResult gameResult = GameResult.create();

		while (!gameResult.isAnswer()) {
			GameMessage.enterNumber();
			String userInput = Console.readLine();
			Validator.validateBallsInput(userInput);
			Balls user = Balls.create(userInput);
			gameResult = computer.getGameResult(user);
		}
		GameMessage.endGame();
	}
}
