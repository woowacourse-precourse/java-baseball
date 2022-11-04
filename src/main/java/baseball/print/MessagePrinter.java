package baseball.print;

import static baseball.print.Message.*;

public class MessagePrinter {

    public void printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printEnterNumberMessage() {
        System.out.print(INPUT_A_NUMBER_MESSAGE);
    }

    public void printBallAndStrikeCount(String counts) {
        System.out.println(counts);
    }

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printCorrectAnswerMessage() {
        System.out.print(CORRECT_ANSWER_MESSAGE);
    }

    public void printRestartMessage() {
        System.out.println(RESTART_GAME_MESSAGE);
    }
}
