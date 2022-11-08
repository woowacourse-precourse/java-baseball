package baseball.Domain;
import baseball.Util.Constant;
import baseball.Util.ValidHandler;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class computerAnswerNumberGenerator {

    private static ArrayList<Integer> answerNumberList;

    public computerAnswerNumberGenerator() {
        answerNumberList = setAnswerNumberList();
    }

    public ArrayList<Integer> getAnswerNumberList() {
        return answerNumberList;
    }

    private static ArrayList<Integer> setAnswerNumberList() {
        String answerNumber;
        answerNumber = generateAnswerNumber().toString();
        return (ArrayList<Integer>) ValidHandler.addList(answerNumber);
    }

    public static ArrayList<Integer> generateAnswerNumber() {
        while(answerNumberList.size() < Constant.MAX_NUM_SIZE) {
            isRightAnswerList(Randoms.pickNumberInRange(Constant.MIN_NUM_RANGE,Constant.MAX_NUM_RANGE),answerNumberList);
        }
        return answerNumberList;
    }

    public static void isRightAnswerList(int correctNumber, List<Integer> answer) {
        if(answer.contains(correctNumber)) {

        }
        answer.add(correctNumber);
    }
}
