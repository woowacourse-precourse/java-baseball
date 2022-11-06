package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballConstants.*;

public class Computer {
    private final List<Character> baseballNumber = new ArrayList<>();
    private final CounterBaseball counterBaseball = new CounterBaseball();

    public List<Character> getBaseballNumber() {
        return baseballNumber;
    }

    public void makeRandomNumber() {
        baseballNumber.clear();
        while (baseballNumber.size() < DIGIT_MAX) {
            addRandomNumber();
        }
    }

    private void addRandomNumber() {
        char randomNumber = Character.forDigit((Randoms.pickNumberInRange(LOWER_NUMBER,
                UPPER_NUMBER)), TEN_DECIMAL);
        if (!baseballNumber.contains(randomNumber)) {
            baseballNumber.add(randomNumber);
        }
    }

    public void countBallAndStrike(String input) {
        counterBaseball.countBallAndStrike(baseballNumber, input);
    }

    public void replyBallAndStrike() {
        int ball = counterBaseball.getBall();
        int strike = counterBaseball.getStrike();
        if ((ball == NO_BALL) && (strike == NO_STRIKE)) {
            View.printNothing();
        }
        if ((ball == NO_BALL) && !(strike == NO_STRIKE)) {
            View.printStrike(strike);
            if(strike == ALL_STRIKE){
                View.printCollect();
            }
        }
        if (!(ball == NO_BALL) && (strike == NO_STRIKE)) {
            View.printBall(ball);
        }
        if (!(ball == NO_BALL) && !(strike == NO_STRIKE)) {
            View.printBallAndStrike(ball, strike);
        }
    }

    public boolean isCollect() {
        return (counterBaseball.getStrike() == 3);
    }

}
