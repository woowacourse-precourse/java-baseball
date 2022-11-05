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

    public Integer checkStrike(int userNumber, int idx){
        if(answerNumber.contains(userNumber) && answerNumber.indexOf(userNumber) == idx){
            return 1;
        }
        return 0;
    }

    public Integer checkBall(int userNumber, int idx){
        if(answerNumber.contains(userNumber) && answerNumber.indexOf(userNumber) == idx){
            return 1;
        }
        return 0;
    }
}
