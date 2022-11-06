package baseball.Input;

import baseball.tool.BeforeVerificationSetting;

import static baseball.tool.BeforeVerificationSetting.*;

public class InputNumberVerification {

    public static boolean verifyNumber (int receivedNumber){

        if(!verifyNumberOverlap(receivedNumber)){
            throw new IllegalArgumentException("각자 다른 숫자를 입력해주세요");
        }

        if(!verifyNumberOneToNine(receivedNumber)){
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요");
        }

        if(!verifyNumberThreeDigit(receivedNumber)){
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요");
        }

        return true;
    }

    private static boolean verifyNumberOverlap(int receivedNumber){
        return makeNumberSplitList(receivedNumber).size()
                == makeNumberSplitSet(receivedNumber).size();
    }

    private static boolean verifyNumberOneToNine(int receivedNumber){
        int cnt = 0;
        for(int oneNumber : makeNumberSplitList(receivedNumber)){
            if(!(1 <= oneNumber  && oneNumber <=9)){
                return false;
            }
        }
        return true;
    }

    private static boolean verifyNumberThreeDigit(int receivedNumber){
        return makeNumberSplitList(receivedNumber).size() == 3;
    }

    public static boolean verifyOneOrTwoButton(int receivedButtonNumber){
        return receivedButtonNumber == 1 || receivedButtonNumber == 2;
    }
}
