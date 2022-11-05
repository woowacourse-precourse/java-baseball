package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintResult.printLineln(PrintResult.GAME_START);

        try {
            startGame();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 게임 시작 함수
     */
    public static void startGame() {
        while (true) {
            startEachGame();

            String gameStatus = Console.readLine();
            if ("2".equals(gameStatus)) {
                break;
            }
        }
    }

    /**
     * 각 게임 1판 시작 함수
     */
    public static void startEachGame() {
        Baseball baseball = new Baseball();

        while (true) {
            PrintResult.printLine(PrintResult.INPUT_INFO);
            String ret = Console.readLine();

            // 예외처리 : 1~9 이외의 값인지 확인
        }
    }
}
