package baseball.view;

import baseball.util.Message;

public class OutputView {
    public static void printGameStart() {
        System.out.println(Message.GAME_START);
    }

    public static void printInputRequest() {
        System.out.print(Message.INPUT_REQUEST);
    }

    public static void printRestartOrEnd() {
        System.out.println(Message.RESTART_OR_END);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printGameEnd() {
        System.out.println(Message.GAME_END);
    }
}
