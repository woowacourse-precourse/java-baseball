package baseball.Input;

public class InputAndVerification {
    InputNumber inputNumber = new InputNumber();
    InputNumberVerification inputNumberVerification = new InputNumberVerification();

    public int receiveAndVerifyNumber() {
        int receivedNumber = inputNumber.getInputNumber();

        inputNumberVerification.verifyNumber(receivedNumber);

        return receivedNumber;
    }

    public int receiveAfterGameEndOneOrTwo() {
        int receivedButtonNumber = inputNumber.getRestartAndEndNumber();

        inputNumberVerification.verifyOneOrTwoButton(receivedButtonNumber);

        return receivedButtonNumber;
    }
}