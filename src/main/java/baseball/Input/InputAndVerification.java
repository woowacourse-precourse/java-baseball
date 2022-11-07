package baseball.Input;

import static baseball.Input.InputNumberVerification.verifyNumber;
import static baseball.Input.InputNumberVerification.verifyOneOrTwoButton;

public class InputAndVerification {
    InputNumber inputNumber = new InputNumber();

    public int receiveAndVerifyNumber() {
        int receivedNumber = inputNumber.getInputNumber();

        if (!verifyNumber(receivedNumber)) {
            throw new IllegalArgumentException("형식에 맞게 입력하세요");
        }
        return receivedNumber;
    }

    public int receiveAfterGameEndOneOrTwo() {
        int receivedButtonNumber = inputNumber.getRestartAndEndNumber();

        if (!verifyOneOrTwoButton(receivedButtonNumber)) {
            throw new IllegalArgumentException("1, 2 둘 중 하나만 골르세요");
        }
        return receivedButtonNumber;
    }
}