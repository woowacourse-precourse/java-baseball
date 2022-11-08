package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        InputException.userInputValidationCheck(input);
        return input;
    }
}
