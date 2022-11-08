package baseball;

public class BaseBall {
	public static void start() {
		Balls computer = Balls.createRandom();
		GameResult gameResult = GameResult.createEmpty();

		while (!gameResult.isAnswer()) {
			Balls user = getBallsWithUserInput();
			gameResult = computer.getGameResultVersus(user);
			GameMessage.informResult(gameResult);
		}
		GameMessage.endGame();
		askQuitOrRestart();
	}

	private static Balls getBallsWithUserInput() {
		GameMessage.enterNumber();
		String userInput = InputHandler.getUserBallsNumbers();

		return Balls.create(userInput);
	}

	private static void askQuitOrRestart() {
		GameMessage.quitOrRestart();
		String quitOrRestart = InputHandler.getQuitOrRestart();

		if (quitOrRestart.equals(UserResponse.RESTART.getValue())) {
			start();
		}
	}
}
