package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayerInputView {
    public static final String INPUT_MESSAGE = "\n숫자를 입력해주세요 : ";

    public static String startInput() {
        System.out.print(INPUT_MESSAGE);
        String inputNum = Console.readLine();
        CheckException.validationNumber(inputNum);
        return inputNum;
    }
}
