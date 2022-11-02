package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static void playGame() {

    }

    public static boolean isGameContinued() {
        int input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        input = Integer.parseInt(Console.readLine());

        if (input == GameStatus.START.getStatus()) {
            return true;
        }

        if (input == GameStatus.END.getStatus()) {
            return false;
        }

        throw new IllegalArgumentException(WarningMessage.IllegalArgumentExceptionWarningMessage.getMessage());
    }
}
