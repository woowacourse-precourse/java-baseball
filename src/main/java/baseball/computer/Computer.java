package baseball.computer;

import baseball.BaseballChecker;
import baseball.View;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballConstants.*;

public class Computer {
    private final List<Character> baseballNumber = new ArrayList<>();
    private final BaseballCounter baseballCounter = new BaseballCounter();

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
        baseballCounter.countBallAndStrike(baseballNumber, input);
    }

    public void replyBallAndStrike(){
        BaseballChecker baseballchecker = new BaseballChecker();
        int ball = baseballCounter.getBall();
        int strike = baseballCounter.getStrike();
        baseballchecker.reply(ball, strike);
    }

    public boolean isCollect() {
        return (baseballCounter.getStrike() == ALL_STRIKE);
    }

}
