package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static boolean keepGaming = true;

    public static void main(String[] args) {
        do {
            playSmallGame();
            isKeepGaming();
        } while (keepGaming);
    }

    private boolean isKeepGaming() {
        String endGame = Console.readLine();
        if (endGame == "1") {
            keepGaming = true;
        } else if (endGame == "2") {
            keepGaming = false;
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하여 프로그램을 종료합니다.");
        }
        return keepGaming;
    }
}
