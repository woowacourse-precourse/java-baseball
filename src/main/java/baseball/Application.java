package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String userInput = new String();
        printGameStartMessage();
        do {
            printGameRestartMessage();
            userInput = Console.readLine();
        } while (parseUserInputForRestart(userInput));
    }

    static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static void printGameRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static boolean parseUserInputForRestart(String userInput) {
        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
