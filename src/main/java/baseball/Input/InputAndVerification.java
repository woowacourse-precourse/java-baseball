package baseball.Input;

public class InputAndVerification {

    public int receiveAndVerifyNumber(){
        InputNumber inputNumber = new InputNumber();
        InputNumberVerification inputNumberVerification = new InputNumberVerification();
        int receivedNumber = inputNumber.getInputNumber();

        if(!inputNumberVerification.verifyNumber(receivedNumber)){
            //프로그램 종료 시키는 메서드
        }
        return receivedNumber;
    }
}
