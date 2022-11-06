package baseball.Model;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class computerAnswerNumGenerator {

    private final static int MIN_NUM_RANGE = 1;
    private final static int MAX_NUM_RANGE = 9;
    private final static int MAX_NUM_SIZE = 3;

    List<Integer> answerNumList = new ArrayList<Integer>();

    public List<Integer> getAnswerNum() {
        while(answerNumList.size() < MAX_NUM_RANGE) {
            isRightAnswerList(Randoms.pickNumberInRange(MIN_NUM_RANGE,MAX_NUM_SIZE),answerNumList);
        }
        return answerNumList;
    }

    public void isRightAnswerList(int correctNum, List<Integer> answer) {
        if(answer.contains(correctNum)) {

        }
        answer.add(correctNum);
    }
}
