package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static String mode;

    private static void readMode() {
        mode = Console.readLine();
    }

    private static boolean isEnd() {
        if (mode.equals("2")) {
            return true;
        }
        return false;
    }

    private static void playBaseball() {
        Baseball baseball = new Baseball();

        while (!isEnd()) {
            baseball = new Baseball();
            baseball.gameStart();
            readMode();
        }
    }

    private static void printInit() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void modeInit() {
        mode = "1";
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        modeInit();
        printInit();
        playBaseball();
    }
}
