package baseball;

public class BaseBall {
	public static final String RESTART = "1";

	public static void start() {
		GameMessage.startGame();
		Balls computer = Balls.createRandom();
		GameResult gameResult = GameResult.create();

		while (!gameResult.isAnswer()) {
			GameMessage.enterNumber();
			String userInput = InputHandler.getUserBallsNumbers();
			Balls user = Balls.create(userInput);
			gameResult = computer.getGameResult(user);
			GameMessage.printResult(gameResult);
		}
		GameMessage.endGame();
		GameMessage.quitOrRestart();
		quitOrRestart(InputHandler.getQuitOrRestart());
	}

	private static void quitOrRestart(String quitOrRestart) {
		if (quitOrRestart.equals(RESTART)) {
			start();
		}
	}
}
