package baseball.view;

import baseball.util.Message;

public class OutputView {
    public static void printGameStart() {
        System.out.println(Message.GAME_START);
    }

    public static void printInputRequest() {
        System.out.print(Message.INPUT_REQUEST);
    }

    public static void printEndOrNot() {
        System.out.println(Message.END_OR_NOT);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
