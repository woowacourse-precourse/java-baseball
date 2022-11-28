package baseball.view;

import static baseball.view.Message.INPUT_PLAYER_NUM_MESSAGE;
import static baseball.view.Message.START_MESSAGE;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputPlayerNumMessage() {
        System.out.println(INPUT_PLAYER_NUM_MESSAGE);
    }

}
