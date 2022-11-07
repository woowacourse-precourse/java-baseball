package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        List<Integer> computerNumber = Utils.pickComputerNumber();
        boolean applicationStatus = true;
        boolean gameStatus = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (applicationStatus) {
            while (gameStatus) {
                System.out.print("숫자를 입력해주세요 : ");
                String line = Console.readLine();
                List<Integer> userNumber = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    userNumber.add(Character.getNumericValue(line.charAt(i)));
                }

                int ball = 0;
                int strike = 0;
                for (int i = 0; i < computerNumber.size(); i++) {
                    if (computerNumber.get(i) == userNumber.get(i)) {
                        strike++;
                    } else if (computerNumber.contains(userNumber.get(i))) {
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
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String line = Console.readLine();
            if ("2".equals(line)) {
                applicationStatus = false;
                System.out.println("게임 종료");
            }
        }
    }
}
