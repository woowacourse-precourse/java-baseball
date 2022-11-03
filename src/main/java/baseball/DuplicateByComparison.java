package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.AnswerNumber.makeAnswerNumber;
import static baseball.BeforeVerificationSetting.makeNumberSplitList;

public class DuplicateByComparison {

    public static List<Integer> findOverlapNumber(int i){
        List<Integer> overlapNumber = new ArrayList<>();

        for(int number : makeAnswerNumber()){
            if(makeNumberSplitList(i).equals(number)){
                overlapNumber.add(number);
            }
        }
        return overlapNumber;
    }
}
