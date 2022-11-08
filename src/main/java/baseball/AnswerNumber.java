package baseball;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;


public class AnswerNumber {
    public ArrayList<Integer> getAnswerNumber() {
        ArrayList<Integer> answerNumList = new ArrayList<Integer>();

        while(answerNumList.size() < 3) {
            checkNumberInList(setAnswerNumber(), answerNumList);
        }

        return answerNumList;
    }

    public void checkNumberInList(int num, ArrayList<Integer> checkList) {
        if(!checkList.contains(num)) {
            checkList.add(num);
        }
    }

    public int setAnswerNumber() {
        int answerThreeNum = Randoms.pickNumberInRange(1, 9);
        return answerThreeNum;
    }

}
