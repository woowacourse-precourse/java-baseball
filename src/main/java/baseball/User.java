package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Message;
import validator.NumberValidator;

public class User {
    private static String inputNumber;

    public void setNumber() {
        inputNumber = getNumberFromInput();
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public String getNumberFromInput() {
        Message.showNumberRequestMessage();
        String inputNumber = Console.readLine();

        validateNumber(inputNumber);
        return inputNumber;
    }

    private void validateNumber(String inputNumber) {
        NumberValidator.validate(inputNumber);
    }
}
