package baseball;

public class GameManager {
	private static void play() {
		boolean threeStrikeFlag = false;
		String userInput;

		Opponent.initAnswer();
		while (!threeStrikeFlag) {
			IOHandler.writeInputMessage();
			userInput = IOHandler.readInput();
			Validator.doNumberValidation(userInput);
			threeStrikeFlag = Opponent.judge(userInput);
		}
		IOHandler.writeCompleteMessage();
	}
}
