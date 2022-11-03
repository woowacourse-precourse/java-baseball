package baseball.view;

import baseball.utils.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_MESSAGE_ENTER_USER_INPUT = "숫자를 입력해주세요 : ";
    private static final String INPUT_MESSAGE_CONTINUE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String receiveUserInput() {
        System.out.print(INPUT_MESSAGE_ENTER_USER_INPUT);
        return Console.readLine();
    }

    public static boolean decideContinueGame() {
        System.out.println(INPUT_MESSAGE_CONTINUE_GAME);
        String gameCode = Console.readLine();
        UserInputValidator.isValidGameCode(gameCode);
        return gameCode.equals(UserInputValidator.KEEP_PLAY_GAME_CODE);
    }
}
