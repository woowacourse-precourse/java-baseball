package baseball.number.game;

import java.util.ArrayList;
import java.util.List;

import static baseball.number.game.Game.*;

public class HintsAboutNumbers {

    List<Integer> playerDigitNumbers = new ArrayList<>();
    List<Integer> randomDigitNumbers = new ArrayList<>();

    public boolean hintAboutNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {

        playerDigitNumbers = playerNumbers;
        randomDigitNumbers = computerNumbers;

        List<Integer> numbersOfBallAndStrike = countBallAndStrike();

        return isBallOrStrike(numbersOfBallAndStrike);
    }

    private boolean isBallOrStrike(List<Integer> ballAndStrike) {

        int strike = ballAndStrike.get(0);
        int totalBall = ballAndStrike.get(1);
        int ball = totalBall - strike;

        if(totalBall == strike && totalBall > 0) {
            System.out.println(strike + STRIKE_HINT_MESSAGE.getValue());
            return strike == 3;
        }
        if(strike >= 0 && ball > 0 &&ball <= 3) {
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

    public List<Integer> countBallAndStrike() {

        int totalBall = 0;
        int strike = 0;

        for(int i = 0; i<3; i++) {
            int playerDigitNumber = playerDigitNumbers.get(i);
            int randomDigitNumber = randomDigitNumbers.get(i);

            totalBall = isDigitNumberContain(playerDigitNumber, totalBall);
            strike = isDigitNumberMatch(playerDigitNumber,randomDigitNumber,strike);
        }
        return List.of(strike, totalBall);
    }

    public int isDigitNumberMatch (int playerDigitNumber, int randomDigitNumber, int strike) {
        if(playerDigitNumber == randomDigitNumber) {
            strike++;
        }
        return strike;
    }

    public int isDigitNumberContain(int playerDigitNumber, int totalBall){
        if(randomDigitNumbers.contains(playerDigitNumber)) {
            totalBall++;
        }
        return totalBall;
    }
}
