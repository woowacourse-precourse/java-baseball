package baseball;

public class Application {
	public static void main(String[] args) {
		UserPlayer userPlayer = UserPlayer.getInstance();
		final UserInputValidator userInputValidator = new UserInputValidator();

		BaseballGameController baseballGameController = new BaseballGameController(userPlayer, userInputValidator);
		baseballGameController.startGame();
    }
}
