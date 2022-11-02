package baseball;

public class Application {

	public static final int GAME_CONTINUE_SIGNAL = 1;

	public static void main(String[] args) {
		int repetition;
		do {
			repetition = GameHandler.startGame(RandomNumber.makeRandomNumber());
		} while (repetition == GAME_CONTINUE_SIGNAL);
	}

}
