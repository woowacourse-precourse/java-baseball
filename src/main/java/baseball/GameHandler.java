package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameHandler {

	public static int startGame(int ans) {

		int userInputAns;
		boolean isAnswer;

		while (true) {
			PrintHandler.printInputNumber();
			userInputAns = UserInputHandler.inputNum();
			isAnswer = AnswerChecking.checkAnswer(ans, userInputAns);

			if (!isAnswer) {
				HintMaking.countBallAndStrike(ans, userInputAns);
			} else {
				PrintHandler.printEndGame();
				break;
			}
		}

		PrintHandler.printAgainGame();
		return Integer.parseInt(Console.readLine());
	}

}
