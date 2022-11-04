package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public static boolean resultOutput(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (strike != 0) {
            if (ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else {
                System.out.println(strike + "스트라이크");
            }
        } else {
            if (ball != 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println("낫싱");
            }
        }
        return false;
    }

    public static boolean exitOrRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            String input = Console.readLine();
            if (input.equals("1")) {
                return false;
            }
            if (input.equals("2")) {
                return true;
            }
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
