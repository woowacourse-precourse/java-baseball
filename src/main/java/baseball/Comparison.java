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
        if (isAnswer(userNum)) {
            Message win = new Message();
        } else {
            retainSameNumber(userNum);
            getMessage(userNum);
        }
    }

    boolean isAnswer(List<Integer> userNum) {
        return computerNum.equals(userNum);
    }

    void retainSameNumber(List<Integer> userNum) {
        copyUserNum = new ArrayList<>(userNum);
        copyUserNum.retainAll(computerNum);
    }

    void getMessage(List<Integer> userNum) {
        if (hasSameNum()) {
            createStrikeBallMessage(userNum);
        } else {
            createNothingMessage(userNum);
        }
    }

    boolean hasSameNum() {
        return (copyUserNum.isEmpty());
    }

    void createStrikeBallMessage(List<Integer> userNum) {
        checkStrike(userNum);
        getStrikeBallMessage(userNum);
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

    void getStrikeBallMessage(List<Integer> userNum) {
        ball = copyUserNum.size() - strike;
        Message ballStrike = new Message(strike, ball, computerNum, userNum);
    }

    void createNothingMessage(List<Integer> userNum) {
        Message nothing = new Message(computerNum, userNum);
    }
}
