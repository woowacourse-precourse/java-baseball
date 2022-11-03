package baseball;

import java.util.LinkedHashSet;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private LinkedHashSet<Character> correctNum = new LinkedHashSet<>(3);
    private int strike = 0;
    private int ball = 0;
    private boolean status = false;


    BaseballGame() {
        makeRandomNum();
        setStatus(true);
    }


    protected int getStrike() {
        return strike;
    }
    protected int getBall() {
        return ball;
    }
    protected boolean getStatus() {
        return status;
    }
    protected LinkedHashSet<Character> getCorrectNum() {
        return correctNum;
    }
    protected void setStrike(int n) {
        strike = n;
    }
    protected void setBall(int n) {
        ball = n;
    }
    protected void setStatus(boolean b) {
        status = b;
    }
    protected void makeRandomNum() {
        while (correctNum.size() < 3) {
            char randomNumber = (char) (Randoms.pickNumberInRange(1, 9) + '0');
            correctNum.add(randomNumber);
        }
    }

    protected void endGame() {

        status = false;
    }
}
