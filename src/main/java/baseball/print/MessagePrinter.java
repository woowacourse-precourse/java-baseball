package baseball.print;

import java.util.Map;

import static baseball.print.Message.*;

public class MessagePrinter {

    public void printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printEnterNumberMessage() {
        System.out.println(INPUT_A_NUMBER_MESSAGE);
    }

    public void printWordNothing() {
        System.out.println(NOTHING);
    }

    public void printBallAndStrikeCount(Map<String, Integer> ballAndStrikeCount) {
        Integer ballCount = ballAndStrikeCount.get("ball");
        Integer strikeCount = ballAndStrikeCount.get("strike");

        if (ballCount == 3) {
            System.out.println(ballCount + BALL);
            return;
        }

        System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
    }

    public void printCorrectAnswerMessage() {
        System.out.println(CORRECT_ANSWER_MESSAGE);
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printRestartMessage() {
        System.out.println(RESTART_GAME_MESSAGE);
    }
}
