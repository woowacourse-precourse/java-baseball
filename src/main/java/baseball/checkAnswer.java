package baseball;

import java.util.ArrayList;
import java.util.List;

public class checkAnswer {
    public static List<Integer> checkAnswer(List<Integer> inputNumber, List<Integer> answerNumber, int i) {
        List<Integer> numLst = new ArrayList<>();

        int strikeNum = 0;
        int ballNum = 0;

        if(answerNumber.contains(inputNumber.get(i))) {
            if(answerNumber.get(i).equals(inputNumber.get(i))) {
                strikeNum += 1;
            } else {
                ballNum += 1;
            }
            /**
             * indent 3초과 리팩터링 하기
             */
        }
        numLst.add(strikeNum);
        numLst.add(ballNum);

        return numLst;
    }
}
