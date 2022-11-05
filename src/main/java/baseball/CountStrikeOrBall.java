package baseball;

import java.util.List;

import static baseball.tool.BeforeVerificationSetting.makeNumberSplitList;
import static baseball.tool.DuplicateByComparison.findOverlapNumber;

public class CountStrikeOrBall {

    public static int getStrikeNumber(List<Integer> answerNumber, int receivedNumber){
        List<Integer> overlapNumber = findOverlapNumber(answerNumber, receivedNumber);
        int strikeNumberCnt = 0;

        for(int overlap : overlapNumber){

            if(answerNumber.indexOf(overlap) == makeNumberSplitList(receivedNumber).indexOf(overlap)){
                strikeNumberCnt += 1;
            }
        }
        return strikeNumberCnt;
    }

    public static int getBallNumber(List<Integer> answerNumber, int receivedNumber){
        List<Integer> overlapNumber = findOverlapNumber(answerNumber, receivedNumber);
        int ballNumberCnt = 0;

        for(int overlap : overlapNumber){
            if(answerNumber.indexOf(overlap) != makeNumberSplitList(receivedNumber).indexOf(overlap)){
                ballNumberCnt += 1;
            }
        }
        return ballNumberCnt;
    }
}
