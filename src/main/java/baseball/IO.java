package baseball;

import camp.nextstep.edu.missionutils.Console;

public class IO {

    public static void alert_startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void alert_hint(int strike, int ball, boolean isNothing) {
        if (isNothing) {
            System.out.println("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    public static void alert_endGame() {
        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void alert_wrongValue() {
        System.out.println("잘못된 값을 입력하셨습니다.");
    }

    public static void alert_endProgram() {
        System.out.println("프로그램을 종료합니다.");
    }

    public static String ask_predict() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String ask_repeat() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
