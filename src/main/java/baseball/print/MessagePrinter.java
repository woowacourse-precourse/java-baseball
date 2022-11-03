package baseball.print;

import java.util.Map;

import static baseball.print.Message.*;

public class MessagePrinter {

    private static final String BALL_KEY = "ball";
    private static final String STRIKE_KEY = "strike";

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
        Integer ballCount = ballAndStrikeCount.get(BALL_KEY);
        Integer strikeCount = ballAndStrikeCount.get(STRIKE_KEY);

        if (ballCount == 3) {
            System.out.println(ballCount + BALL);
            return;
        }

        if (strikeCount == 3) {
            System.out.println(strikeCount + STRIKE);
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
