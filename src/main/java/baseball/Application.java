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
            String userInput = Console.readLine();

            // 예외처리 : 1~9 이외의 값인지 확인
            isGameNumber(userInput);
        }
    }

    /**
     * 사용자 입력이 게임 숫자인지 확인
     * 1. 사이즈가 게임 숫자 사이즈
     * 2. 숫자 1~9의 숫자만 와야한다.
     * @param userInput
     * @return 게임 숫자이면 True / 아니면 False
     */
    public static void isGameNumber(String userInput)   {
        if (userInput.length() != Baseball.GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException("사용자 입력 길이가 게임 숫자 길이와 다르다.");
        }

        for (int i=0; i<userInput.length(); i++) {
            char userOneChar = userInput.charAt(i);
            if (userOneChar < '1' || userOneChar > '9') {
                throw new IllegalArgumentException("숫자 이외의 값이 입력되었습니다.");
            }
        }
    }
}
