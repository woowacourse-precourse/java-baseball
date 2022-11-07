package baseball.view;

import baseball.ball.BallNumbers;
import baseball.input.Input;
import baseball.program.ProgramStatus;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String INPUT_GAME_STATE_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


	public static void displayInputNumberMessage() {
		System.out.print(INPUT_NUMBER_MESSAGE);
	}

	public static BallNumbers getUserInputNumbers() {
		char[] userInput = Console.readLine().toCharArray();
		return BallNumbers.convertUserInputToBallNumbers(userInput);
	}

	public static void displayInputGameStateCommandMessage() {
		System.out.println(INPUT_GAME_STATE_COMMAND_MESSAGE);
	}

	public static ProgramStatus getUserInputCommand() {
		int userInput = Input.validateRestartOrEndInput(Console.readLine());

		if (userInput == 1) {
			return ProgramStatus.RESTART;
		}
		return ProgramStatus.END;
	}
}
