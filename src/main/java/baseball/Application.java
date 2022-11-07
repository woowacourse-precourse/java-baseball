package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printGameStartMessage();
        do {
            printGameRestartMessage();
        } while (parseUserInputForRestart());
    }

    static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void printGameRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static boolean parseUserInputForRestart() {
        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
