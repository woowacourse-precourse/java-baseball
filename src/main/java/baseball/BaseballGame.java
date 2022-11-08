package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static BaseballGameInputFilter inputFilter = BaseballGameInputFilter.getInstance();


    private String getAnswerNumber() {
        List<Integer> answerNumbers = new ArrayList<>();
        String answerString = "";

        while (answerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!answerNumbers.contains(randomNumber)) {
                answerString += String.valueOf(randomNumber);
                answerNumbers.add(randomNumber);
            }
        }
        return answerString;
    }

}
