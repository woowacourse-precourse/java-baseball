package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Message;
import validator.NumberValidator;

import static constant.Const.RETRY;

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

    public boolean hasRetryIntention() {
        return getRetryNumber().equals(RETRY);
    }

    private String getRetryNumber() {
        String retryNumber = Console.readLine();

        NumberValidator.checkRetryNumber(retryNumber);
        return retryNumber;
    }
}
