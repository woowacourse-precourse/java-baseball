package baseball;

public class Application {
	/*private static UserPlayer userPlayer;
	private static BaseballGameModel baseballGameModel;
	private static boolean gameStatus;
	private static final UserInputValidator userInputValidator = new UserInputValidator();*/

	public static void main(String[] args) {
		UserPlayer userPlayer = UserPlayer.getInstance();
		ComputerPlayer computerPlayer = new ComputerPlayer();
		BaseballGameModel baseballGameModel = new BaseballGameModel(computerPlayer);
		final UserInputValidator userInputValidator = new UserInputValidator();
		boolean gameStatus;

		BaseballGameController baseballGameController = new BaseballGameController(userPlayer,baseballGameModel,userInputValidator);
		baseballGameController.startGame();
    }
}
