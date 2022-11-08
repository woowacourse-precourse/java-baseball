package baseball.number.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

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
            return strike == 3;
        }
        if(strike >= 0 && ball > 0 && ball <= 3) {
            if(strike == 0) {
                System.out.println(ball + BALL_HINT_MESSAGE.getValue());
                return false;
            }
            System.out.println(ball + BALL_HINT_MESSAGE.getValue()
                    + strike + STRIKE_HINT_MESSAGE.getValue());
            return false;
        }
        System.out.println(NOTHING_HINT_MESSAGE.getValue());
        return false;
    }
    private int countTotalBall() {
        int totalBall = (int) playerDigitNumbers.stream()
                .filter(number -> randomDigitNumbers.stream()
                        .anyMatch(Predicate.isEqual(number))).count();
        return totalBall;
    }

    private int countStrike() {
        int strike = (int) IntStream.range(0, 3).boxed()
                .filter(number -> Objects.equals(playerDigitNumbers.get(number), randomDigitNumbers.get(number)))
                .count();

        return strike;
    }
}
