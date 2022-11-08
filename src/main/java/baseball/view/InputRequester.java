package baseball.view;

import static baseball.util.Parser.stringNumToIntegerNumListParser;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputRequester {
    private List<Integer> userGameNumbers = new ArrayList<>();
    private InputException inputNumbersException = new InputException();
    private String userInput;

    public List<Integer> setUserGameNumbers() {
        printQuestion();
        getUserInput();
        checkUserInputException(userInput);
        toIntegerList(userInput);
        return userGameNumbers;
    }

    public void printQuestion() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void getUserInput() {
        userInput = Console.readLine();
    }

    public void checkUserInputException(String userInput) {
        inputNumbersException.isInputValid(userInput);
    }

    public void toIntegerList(String userInput) {
        userGameNumbers = stringNumToIntegerNumListParser(userInput);
    }
}