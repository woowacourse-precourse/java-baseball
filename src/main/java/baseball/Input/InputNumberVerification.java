package baseball.Input;

import baseball.tool.BeforeVerificationSetting;

public class InputNumberVerification {
    BeforeVerificationSetting beforeVerificationSetting = new BeforeVerificationSetting();

    public boolean verifyNumber (int receivedNumber){

        if(!verifyNumberOverlap(receivedNumber)){
            return false;
        }

        if(!verifyNumberOneToNine(receivedNumber)){
            return false;
        }

        if(!verifyNumberThreeDigit(receivedNumber)){
            return false;
        }

        return true;
    }

    private boolean verifyNumberOverlap(int receivedNumber){
        return beforeVerificationSetting.makeNumberSplitList(receivedNumber).size()
                == beforeVerificationSetting.makeNumberSplitSet(receivedNumber).size();
    }

    private boolean verifyNumberOneToNine(int receivedNumber){
        for(char oneNumber : beforeVerificationSetting.makeNumberSplitArrangement(receivedNumber)){
            if((int) oneNumber <= 0  || 9 < (int) oneNumber){
                return false;
            }
        }
        return true;
    }

    private boolean verifyNumberThreeDigit(int receivedNumber){
        return beforeVerificationSetting.makeNumberSplitArrangement(receivedNumber).length == 3;
    }
}
