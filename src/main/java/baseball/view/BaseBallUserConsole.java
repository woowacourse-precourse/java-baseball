package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallUserConsole {

    /**
     * 1. Console.readLine() 메서드 활용하여 사용자로부터 입력 받음
     * 2. UserInputValidator.validateInput() 메서드로 입력값 유효성 검증 수행
     *
     * Returns : user input string
     * Throws: IllegalArgumentException – if this scanner is closed
     * */
    public static String inputAnswer() {
        String input = Console.readLine();

        UserInputValidator.validateAnswer(input);

        return input;
    }
}
