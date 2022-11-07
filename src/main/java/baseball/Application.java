package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        List<Integer> computerNumber = Utils.pickComputerNumber();

        boolean gameStatus = true;
        while (gameStatus) {
            String line = Console.readLine();
            List<Integer> userNumber = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                userNumber.add(Character.getNumericValue(line.charAt(i)));
            }

            int ball = 0;
            int strike = 0;
            for (int i = 0; i < computerNumber.size(); i++) {
                // strike 확인
                if (computerNumber.get(i) == userNumber.get(i)) {
                    strike++;
                } else if (computerNumber.contains(userNumber.get(i))) {
                    // ball 확인
                    ball++;
                }
            }

            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else if (ball != 0 && strike != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (ball != 0) {
                System.out.println(ball + "볼");
            } else if (strike != 0) {
                System.out.println(strike + "스트라이크");
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameStatus = false;
            }

        }
    }
}
