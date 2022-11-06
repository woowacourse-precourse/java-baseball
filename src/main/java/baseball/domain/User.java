package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import baseball.view.Message;
import baseball.validator.NumberValidator;

import static baseball.constant.Const.RETRY;

public class User {
    private String inputNumber;

    public void enterNumber() {
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
        Message.showRetryRequestMessage();
        String retryNumber = Console.readLine();

        NumberValidator.checkRetryNumber(retryNumber);
        return retryNumber;
    }
}
