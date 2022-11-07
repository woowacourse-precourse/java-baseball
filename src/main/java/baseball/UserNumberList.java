package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserNumberList {

    private static final int NUMBER_LENGTH = Application.NUMBER_LENGTH();
    private List<BaseBallNumber> userBaseballList;

    public UserNumberList(String userInput) {
        validateUserInput(userInput);
        this.userBaseballList = makeBaseBallList(userInput);
    }

    private void validateUserInput(String userInput) {
        Exceptions.checkLength(userInput);
        Exceptions.checkType(userInput);
        Exceptions.checkDuplication(userInput);
    }

    private List<BaseBallNumber> makeBaseBallList(String userInput) {
        List<BaseBallNumber> userNumber = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userNumber.add(new BaseBallNumber(userInput.charAt(i)));
        }
        return userNumber;
    }

    public List<BaseBallNumber> UserNumberList() {
        return Collections.unmodifiableList(userBaseballList);
    }
}
