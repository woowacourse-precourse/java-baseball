package baseball.computer;

import baseball.BallAndStrikeChecker;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.*;

public class Computer {
    private final List<Character> baseballNumber = new ArrayList<>();
    private final BallAndStrikeCounter ballAndStrikeCounter = new BallAndStrikeCounter();

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
        ballAndStrikeCounter.countBallAndStrike(baseballNumber, input);
    }

    public void replyBallAndStrike(){
        BallAndStrikeChecker baseballchecker = new BallAndStrikeChecker();
        int ball = ballAndStrikeCounter.getBall();
        int strike = ballAndStrikeCounter.getStrike();
        baseballchecker.reply(ball, strike);
    }

    public boolean isCollect() {
        return (ballAndStrikeCounter.getStrike() == ALL_STRIKE);
    }

}
