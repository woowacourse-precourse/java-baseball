package baseball.number.client;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println(strike + "스트라이크");
            return strike == 3;
        }
        if(strike >= 0 && ball > 0 &&ball <= 3) {
            if(strike == 0) {
                System.out.println(ball + " 볼");
                return false;
            }
            System.out.println(ball + "볼 "+strike + "스트라이크");
            return false;
        }
        System.out.println("낫싱");
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
