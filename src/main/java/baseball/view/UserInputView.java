package baseball.view;

import static baseball.util.StringNumToIntegerNumListParser.stringNumToIntegerNumListParser;

import baseball.exception.InputNumbersException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInputView {
    private List<Integer> userGameNumbers = new ArrayList<>();
    private InputNumbersException inputNumbersException = new InputNumbersException();

    public List<Integer> setUserGameNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numberTypeOfString = Console.readLine();
        inputNumbersException.checkValidOfUserInput(numberTypeOfString);
        userGameNumbers = stringNumToIntegerNumListParser(numberTypeOfString);
        return userGameNumbers;
    }
}
