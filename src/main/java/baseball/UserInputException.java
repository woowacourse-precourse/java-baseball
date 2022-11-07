package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputException {
    public UserInputException() {
    }

    // 입력받은 자릿수가 세자리가 아니라면 false 리턴
    private boolean checkIfInputIsThreeDigit(String inputString) {
        return inputString.length() == 3;
    }

}
