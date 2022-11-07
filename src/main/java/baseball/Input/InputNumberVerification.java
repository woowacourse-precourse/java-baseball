package baseball.Input;

import static baseball.tool.NumberSplitTool.*;

public class InputNumberVerification {

    public void verifyNumber(int receivedNumber) {

        verifyNumberOverlap(receivedNumber);
        verifyNumberBetweenOneAndNine(receivedNumber);
        verifyNumberThreeDigit(receivedNumber);
    }

    private void verifyNumberOverlap(int receivedNumber) {
        if(!(makeNumberSplitList(receivedNumber).size() == makeNumberSplitSet(receivedNumber).size())){
            throw new IllegalArgumentException("각자 다른 숫자를 입력해주세요");
        }
    }

    private void verifyNumberBetweenOneAndNine(int receivedNumber) {

        for (int oneNumber : makeNumberSplitList(receivedNumber)) {
            if (!(1 <= oneNumber && oneNumber <= 9)) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요");
            }
        }
    }

    private void verifyNumberThreeDigit(int receivedNumber) {
        if (!(makeNumberSplitList(receivedNumber).size() == 3)){
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요");
        }
    }

    public void verifyOneOrTwoButton(int receivedButtonNumber) {
        if(!(receivedButtonNumber == 1 || receivedButtonNumber == 2)){
            throw new IllegalArgumentException("1, 2 둘 중 하나만 고르세요");
        }
    }
}