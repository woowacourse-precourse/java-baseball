package baseball;

import java.util.List;

import static baseball.BeforeVerificationSetting.makeNumberSplitList;
import static baseball.DuplicateByComparison.findOverlapNumber;

public class CountStrikeOrBall {

    public static int getStrikeNumber(List<Integer> answerNumber, int receivedNumber){
        int strikeNumberCnt = 0;
        for(int overlapNumber : findOverlapNumber(receivedNumber)){
            if(answerNumber.indexOf(overlapNumber) == makeNumberSplitList(receivedNumber).indexOf(overlapNumber)){
                strikeNumberCnt += 1;
            }
        }
        return strikeNumberCnt;
    }

    public static int getBallNumber(List<Integer> answerNumber, int receivedNumber){
        int ballNumberCnt = 0;
        for(int overlapNumber : findOverlapNumber(receivedNumber)){
            if(answerNumber.indexOf(overlapNumber) == makeNumberSplitList(receivedNumber).indexOf(overlapNumber)){
                ballNumberCnt += 1;
            }
        }
        return ballNumberCnt;
    }
}
