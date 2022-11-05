package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answerNumber = new ArrayList<>();
    private Integer strike;
    private Integer ball;

    public void makeAnswerNumber(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answerNumber.contains(randomNumber)) {
            answerNumber.add(randomNumber);
        }
    }
}
