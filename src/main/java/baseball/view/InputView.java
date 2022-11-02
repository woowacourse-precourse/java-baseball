package baseball.view;

import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String GET_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String getUserInput() {
        System.out.println(GET_USER_INPUT_MESSAGE);
        String userInput = Console.readLine();
        return userInput;
    }
}
