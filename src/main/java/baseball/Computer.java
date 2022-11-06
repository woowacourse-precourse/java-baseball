package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int BASEBALL_GAME_DIGIT = 3;
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
        char randomNumber = Character.forDigit((Randoms.pickNumberInRange(1, 9)), 10);
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
        if ((ball == 0) && (strike == 0)) {
            View.printNothing();
        }
        if ((ball == 0) && (strike == 3)) {
            View.printCollect();
        }
        if ((ball == 0) && !(strike == 0)) {
            View.printStrike(strike);
        }
        if (!(ball == 0) && (strike == 0)) {
            View.printBall(ball);
        }
        if (!(ball == 0) && !(strike == 0)) {
            View.printBallAndStrike(ball, strike);
        }
    }

    public boolean isCollect() {
        return (counterBaseball.getStrike() == 3);
    }

}
