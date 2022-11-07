package baseball.Model;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class computerAnswerNumberGenerator {

    List<Integer> answerNumberList = new ArrayList<Integer>();

    public List<Integer> getAnswerNumber() {
        while(answerNumberList.size() < Constant.MAX_NUM_RANGE) {
            isRightAnswerList(Randoms.pickNumberInRange(Constant.MIN_NUM_RANGE,Constant.MAX_NUM_SIZE),answerNumberList);
        }
        return answerNumberList;
    }

    public void isRightAnswerList(int correctNumber, List<Integer> answer) {
        if(answer.contains(correctNumber)) {

        }
        answer.add(correctNumber);
    }
}
