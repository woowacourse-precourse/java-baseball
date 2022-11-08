package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Play {

    public static void playStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String answerNumber = createThreeNumber();
        while (true) {
            int strike = checkAnswer(answerNumber);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static String createThreeNumber() {
        int size = 0;
        String randomNumber = "";
        while (size < 3) {
            randomNumber += Randoms.pickNumberInRange(1, 9);
            if (Exception.isRedundancy(randomNumber)) {
                randomNumber = randomNumber.substring(0, randomNumber.length()-1);
                size--;
            }
            size++;
        }
        return randomNumber;
    }

    public static int countBall(String playerNumber, String answerNumber) {
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            if (playerNumber.contains(answerNumber.substring(index, index+1))) {
                ball++;
            }
        }
        return ball;
    }

    public static int countStrike(String playerNumber, String answerNumber) {
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (playerNumber.charAt(index) == answerNumber.charAt(index)) {
                strike++;
            }
        }
        return strike;
    }

    public static void printResult(int ball, int strike) {
        ball = ball - strike;
        if (ball != 0 && strike != 0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball+"볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike+"스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    public static int checkAnswer(String answerNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        if (Exception.isException(playerNumber)) {
            throw new IllegalArgumentException("3자리의 서로 다른 숫자가 아닙니다.");
        }
        int ball = countBall(playerNumber, answerNumber);
        int strike = countStrike(playerNumber, answerNumber);
        printResult(ball, strike);
        return strike;
    }
}
