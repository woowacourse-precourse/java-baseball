package baseball.Input;

public class InputAndVerification {
    InputNumber inputNumber = new InputNumber();
    InputNumberVerification inputNumberVerification = new InputNumberVerification();

    public int receiveAndVerifyNumber(){
        int receivedNumber = inputNumber.getInputNumber();

        if(!inputNumberVerification.verifyNumber(receivedNumber)){
            throw new IllegalArgumentException("형식에 맞게 입력하세요");
        }
        return receivedNumber;
    }

    public int receiveAfterGameEndOneOrTwo(){
        int receivedButtonNumber = inputNumber.getRestartAndEndNumber();

        if(inputNumberVerification.verifyOneOrTwoButton(receivedButtonNumber)){
            throw new IllegalArgumentException("1, 2 둘 중 하나만 골르세요");
        }
        return receivedButtonNumber;
    }
}
