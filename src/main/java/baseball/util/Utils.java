package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class Utils {

    public static String getPlayerInputForGenerateAnswerByConsole() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String getPlayerInputForRestartGameByConsole() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public static void announce(String message) {
        System.out.println(message);
    }
}
