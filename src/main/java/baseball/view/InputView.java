package baseball.view;

import baseball.Exception;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputUserNumber() {
        String inputStringNumber = Console.readLine();
        Exception.userDigitNumberException(inputStringNumber);
        Exception.userNumberDuplicationException(inputStringNumber);

        return inputStringNumber;
    }
}
