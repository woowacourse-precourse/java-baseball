package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}