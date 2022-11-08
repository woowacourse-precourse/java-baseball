package baseball.count;

import java.util.List;

import static baseball.tool.NumberSplitTool.makeNumberSplitList;
import static baseball.tool.DuplicateByComparison.findOverlapNumber;

public class CountStrikeOrBall {

    public int getStrikeNumber(List<Integer> answerNumber, int receivedNumber) {
        List<Integer> overlapNumberList = findOverlapNumber(answerNumber, receivedNumber);
        int strikeNumberCnt = 0;

        for (int overlapNumber : overlapNumberList) {

            if (answerNumber.indexOf(overlapNumber) == makeNumberSplitList(receivedNumber).indexOf(overlapNumber)) {
                strikeNumberCnt += 1;
            }
        }
        return strikeNumberCnt;
    }

    public int getBallNumber(List<Integer> answerNumber, int receivedNumber) {
        List<Integer> overlapNumberList = findOverlapNumber(answerNumber, receivedNumber);
        int ballNumberCnt = 0;

        for (int overlapNumber : overlapNumberList) {
            if (answerNumber.indexOf(overlapNumber) != makeNumberSplitList(receivedNumber).indexOf(overlapNumber)) {
                ballNumberCnt += 1;
            }
        }
        return ballNumberCnt;
    }
}