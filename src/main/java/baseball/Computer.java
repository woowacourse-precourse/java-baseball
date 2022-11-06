package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int BASEBALL_GAME_DIGIT = 3;
    private static final int BASEBALL_LOWER_NUMBER = 1;
    private static final int BASEBALL_UPPER_NUMBER= 9;
    private static final int TEN_DECIMAL = 10;
    private static final int NO_BALL = 0;
    private static final int NO_STRIKE = 0;
    private static final int ALL_STRIKE = 3;
    private final List<Character> baseballNumber = new ArrayList<>();
    private final CounterBaseball counterBaseball = new CounterBaseball();

    public List<Character> getBaseballNumber() {
        return baseballNumber;
    }

    public void makeRandomNumber() {
        baseballNumber.clear();
        while (baseballNumber.size() < BASEBALL_GAME_DIGIT) {
            addRandomNumber();
        }
    }

    private void addRandomNumber() {
        char randomNumber = Character.forDigit((Randoms.pickNumberInRange(BASEBALL_LOWER_NUMBER,
                BASEBALL_UPPER_NUMBER)), TEN_DECIMAL);
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
