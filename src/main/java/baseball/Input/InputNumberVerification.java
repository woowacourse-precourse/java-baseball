package baseball.Input;

import baseball.tool.BeforeVerificationSetting;

public class InputNumberVerification {
    BeforeVerificationSetting beforeVerificationSetting = new BeforeVerificationSetting();

    public boolean verifyNumber (int receivedNumber){

        if(!verifyNumberOverlap(receivedNumber)){
            throw new IllegalArgumentException("각자 다른 숫자를 입력해주세요");
        }

        if(!verifyNumberOneToNine(receivedNumber)){
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요");
        }

        if(!verifyNumberThreeDigit(receivedNumber)){
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }

        return true;
    }

    private boolean verifyNumberOverlap(int receivedNumber){
        return beforeVerificationSetting.makeNumberSplitList(receivedNumber).size()
                == beforeVerificationSetting.makeNumberSplitSet(receivedNumber).size();
    }

    private boolean verifyNumberOneToNine(int receivedNumber){
        for(int oneNumber : beforeVerificationSetting.makeNumberSplitList(receivedNumber)){
            if(1 <= oneNumber  && oneNumber <=9){
                return true;
            }
        }
        return false;
    }

    private boolean verifyNumberThreeDigit(int receivedNumber){
        return beforeVerificationSetting.makeNumberSplitList(receivedNumber).size() == 3;
    }

    public boolean verifyOneOrTwoButton(int receivedButtonNumber){
        if(receivedButtonNumber == 1 || receivedButtonNumber ==2){
            return false;
        }
        return true;
    }
}
