package baseball;

import java.util.ArrayList;
import java.util.List;

public class Comparison {
    private List<Integer> computerNum;
    private List<Integer> copyUserNum;
    private int strike;
    private int ball;

    public Comparison(List<Integer> computerNum, List<Integer> userNum) {
        this.computerNum = computerNum;
        compareNum(userNum);
    }

    void compareNum(List<Integer> userNum) {
        checkEqual(userNum);
        compareDigits(userNum);
    }

    void checkSameNumber(List<Integer> userNum) {
        copyUserNum = new ArrayList<>(userNum);
        copyUserNum.retainAll(computerNum);
    }

    void checkEqual(List<Integer> userNum){
        if(computerNum.equals(userNum)) {
            Message win = new Message();
        }
    }

    void compareDigits(List<Integer> userNum){
        if(!computerNum.equals(userNum)) {
            checkSameNumber(userNum);
            getMessage(userNum);
        }
    }

    void getMessage(List<Integer> userNum) {
        if (copyUserNum.isEmpty()) {
            Message nothing = new Message(computerNum, userNum);
        } else {
            checkStrike(userNum);
            getStrikeBallMessage(userNum); 
        }
    }

    void checkStrike(List<Integer> userNum) {
        for (Integer integer : copyUserNum) {
            int computer = computerNum.indexOf(integer);
            int user = userNum.indexOf(integer);
            countStrike(computer, user);
        }
    }

    void countStrike(int computer, int user) {
        if (computer == user)
            this.strike++;
    }

    void getStrikeBallMessage(List<Integer> userNum){
        ball = copyUserNum.size() - strike;
        Message ballStrike = new Message(strike, ball, computerNum, userNum);
    }
}
