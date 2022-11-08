package baseball.number.game;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static baseball.number.util.GameNumberRange.BALL_SIZE;
import static baseball.number.util.GamePhrase.*;

public class HintsAboutNumbers {

    List<Integer> playerDigitNumbers = new ArrayList<>();
    List<Integer> randomDigitNumbers = new ArrayList<>();

    public boolean hintAboutNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {

        playerDigitNumbers = playerNumbers;
        randomDigitNumbers = computerNumbers;

        int totalBall = countTotalBall();
        int strike = countStrike();

        return isBallOrStrike(totalBall, strike);
    }

    private boolean isBallOrStrike(int totalBall, int strike) {

        int ball = totalBall - strike;

        if(totalBall == strike && totalBall > 0) {
            System.out.println(strike + STRIKE_HINT_MESSAGE.getValue());
            return strike == BALL_SIZE.getNumber();
        }
        if(strike >= 0 && ball > 0 &&ball <= BALL_SIZE.getNumber()) {
            if(strike == 0) {
                System.out.println(ball + BALL_HINT_MESSAGE.getValue());
                return false;
            }
            System.out.println(ball + BALL_HINT_MESSAGE.getValue()
                    +strike + STRIKE_HINT_MESSAGE.getValue());
            return false;
        }
        System.out.println(NOTHING_HINT_MESSAGE.getValue());
        return false;
    }
    private int countTotalBall() {
        int totalBall = (int) playerDigitNumbers.stream()
                .filter(o -> randomDigitNumbers.stream()
                        .anyMatch(Predicate.isEqual(o))).count();
        return totalBall;
    }

    private int countStrike() {
        int strike = 0;

        for(int number = 0; number<3; number++) {
            int playerDigitNumber = playerDigitNumbers.get(number);
            int randomDigitNumber = randomDigitNumbers.get(number);

            strike = isDigitNumberMatch(playerDigitNumber,randomDigitNumber,strike);
        }
        return strike;
    }

    private int isDigitNumberMatch (int playerDigitNumber, int randomDigitNumber, int strike) {
        if(playerDigitNumber == randomDigitNumber) {
            strike++;
        }
        return strike;
    }
}
