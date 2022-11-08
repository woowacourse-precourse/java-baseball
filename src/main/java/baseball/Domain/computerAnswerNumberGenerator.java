package baseball.Domain;
import baseball.Util.Constant;
import baseball.Util.ValidHandler;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class computerAnswerNumberGenerator {

    private static final List<Integer> answerNumberList = null;

    public computerAnswerNumberGenerator() {
    }

    public List<Integer> getAnswerNumberList() {
        return null;
    }

    private static List<Integer> setAnswerNumberList() {
        String answerNumber;
        answerNumber = generateAnswerNumber().toString();
        return ValidHandler.addList(answerNumber);
    }

    public static List<Integer> generateAnswerNumber() {
        while(answerNumberList.size() < Constant.MAX_NUM_RANGE) {
            isRightAnswerList(Randoms.pickNumberInRange(Constant.MIN_NUM_RANGE,Constant.MAX_NUM_SIZE),answerNumberList);
        }
        return null;
    }

    public static void isRightAnswerList(int correctNumber, List<Integer> answer) {
        if(answer.contains(correctNumber)) {

        }
        answer.add(correctNumber);
    }
}
