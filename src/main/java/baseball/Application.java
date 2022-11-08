package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static class IllegalArgumentException extends RuntimeException {
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();
            if (userInput.equals("1")) {
                continue;
            }
            if (userInput.equals("2")) {
                break;
            }
            throw new IllegalArgumentException();
        }
    }

    public static void playGame() {
    }
}
