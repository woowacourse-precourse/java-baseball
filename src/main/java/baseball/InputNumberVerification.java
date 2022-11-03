package baseball;

import java.util.List;
import java.util.Set;

import static baseball.BeforeVerificationSetting.*;

public class InputNumberVerification {

    public static boolean verifyNumber (int receivedNumber){

        if(!verifyNumberOverlap(makeNumberSplitList(receivedNumber), makeNumberSplitSet(receivedNumber))){
            throw new IllegalArgumentException("중복 숫자 있음");
        }

        if(!verifyNumberOneToNine(makeNumberSplitArrangement(receivedNumber))){
            throw new IllegalArgumentException("숫자 1~9 이외의 숫자 있음");
        }

        if(!verifyNumberThreeDigit(makeNumberSplitArrangement(receivedNumber))){
            throw new IllegalArgumentException("세개 숫자 입력 안함");
        }

        return true;
    }

    public static boolean verifyNumberOverlap(List<Integer> numberSplitList, Set<Integer> numberSplitSet){
        return numberSplitList.size() == numberSplitSet.size();
    }

    public static boolean verifyNumberOneToNine(char[] numberSplitArrangement){
        for(char oneNumber : numberSplitArrangement){
            if((int) oneNumber <= 0  || 9 < (int) oneNumber){
                return false;
            }
        }
        return true;
    }

    public static boolean verifyNumberThreeDigit(char[] numberSplitArrangement){
        return numberSplitArrangement.length == 3;
    }
}
