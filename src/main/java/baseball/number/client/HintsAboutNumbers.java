package baseball.number.client;

import baseball.utils.validation.Validation;

import java.util.ArrayList;
import java.util.List;

public class HintsAboutNumbers {

    List<Integer> clientDigitNumbers = new ArrayList<>();
    List<Integer> randomDigitNumbers = new ArrayList<>();

    public boolean hintAboutNumbers(List<Integer> clientNumbers, List<Integer> computerNumbers) {

        clientDigitNumbers = clientNumbers;
        randomDigitNumbers = computerNumbers;

        List<Integer> numbersOfBallAndStrike = countBallAndStrike();

        return isBallOrStrike(numbersOfBallAndStrike);
    }

    public boolean isBallOrStrike(List<Integer> ballAndStrike) {

        int ball = ballAndStrike.get(0);
        int strike = ballAndStrike.get(1);

        if(strike <= 3 && strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
            return strike == 3;
        }
        if(strike < 3 && strike >= 0 && ball > 0 &&ball <= 3) {
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
        int ball = 0;
        int strike = 0;

        for(int i = 0; i<3; i++) {
            int clientDigitNumber = clientDigitNumbers.get(i);
            int randomDigitNumber = randomDigitNumbers.get(i);

            totalBall = isDigitNumberContain(clientDigitNumber, totalBall);
            strike = isDigitNumberMatch(clientDigitNumber,randomDigitNumber,strike);
            ball = totalBall - strike;
        }
        return List.of(ball, strike);
    }

    public int isDigitNumberMatch (int clientDigitNumber, int randomDigitNumber, int strike) {
        if(clientDigitNumber == randomDigitNumber) {
            strike++;
        }
        return strike;
    }

    public int isDigitNumberContain(int clientDigitNumber, int totalBall){
        if(randomDigitNumbers.contains(clientDigitNumber)) {
            totalBall++;
        }
        return totalBall;
    }
}
