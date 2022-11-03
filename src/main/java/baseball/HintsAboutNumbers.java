package baseball;

import java.util.ArrayList;
import java.util.List;

public class HintsAboutNumbers {

    List<Integer> clientDigitNumbers = new ArrayList<>();
    List<Integer> randomDigitNumbers = new ArrayList<>();

    public boolean hintAboutNumbers(int clientNumber, int randomNumber) {

        String strClientNumber = String.valueOf(clientNumber);
        String strRandomNumber = String.valueOf(randomNumber);

        clientDigitNumbers = getDigitNumberList(strClientNumber);
        randomDigitNumbers = getDigitNumberList(strRandomNumber);

        List<Integer> numbersOfBallAndStrike = countBallAndStrike();

        return isBallOrStrike(numbersOfBallAndStrike);
    }

    public List<Integer> getDigitNumberList(String StringNumber) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<StringNumber.length(); i++) {
            String strDigitNumbers = String.valueOf(StringNumber.charAt(i));
            int number = Integer.parseInt(strDigitNumbers);
            list.add(number);
        }
        return list;
    }

    public boolean isBallOrStrike(List<Integer> ballAndStrike) {

        int ball = ballAndStrike.get(0);
        int strike = ballAndStrike.get(1);

        if(strike <= 3 && strike > 0 && ball == 0) {
            System.out.println(strike + " 스트라이크");
            return strike == 3;
        }
        if(strike >= 0 && strike < 3 && ball > 0 && ball <= 3) {
            if(strike == 0) {
                System.out.println(ball + " 볼");
                return false;
            }
            System.out.println(ball + " 볼");
            System.out.println(strike + " 스트라이크");
            return false;
        }
        System.out.println("낫싱");
        return false;
    }

    public List<Integer> countBallAndStrike() {

        int ball = 0;
        int strike = 0;

        for(int i = 0; i<3; i++) {
            int clientDigitNumber = clientDigitNumbers.get(i);
            int randomDigitNumber = randomDigitNumbers.get(i);

            strike = isDigitNumberMatch(clientDigitNumber,randomDigitNumber,strike);
            ball = isDigitNumberContain(clientDigitNumber, ball, i);
        }
        return List.of(ball, strike);
    }

    public int isDigitNumberMatch (int clientDigitNumber, int randomDigitNumber, int strike) {
        if(clientDigitNumber == randomDigitNumber) {
            strike++;
        }
        return strike;
    }

    public int isDigitNumberContain(int clientDigitNumber, int ball, int i){
        if(randomDigitNumbers.contains(clientDigitNumber) && randomDigitNumbers.get(i) != clientDigitNumber) {
            ball++;
        }
        return ball;
    }
}
