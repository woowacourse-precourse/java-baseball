package baseball.view;

import static baseball.view.Message.*;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(START_MESSAGE.get());
    }

    public static void printInputPlayerNumMessage() {
        System.out.print(INPUT_PLAYER_NUM_MESSAGE.get());
    }

    public static void printResult(String result) {
        System.out.print(result);
    }
}
