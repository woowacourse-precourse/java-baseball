package baseball.print;

import java.util.Map;

import static baseball.config.GameConfiguration.DIGITS_FOR_THIS_GAME;
import static baseball.config.MapKeyStorage.BALL_KEY;
import static baseball.config.MapKeyStorage.STRIKE_KEY;
import static baseball.print.Message.*;

public class MessagePrinter {

    public void printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printEnterNumberMessage() {
        System.out.print(INPUT_A_NUMBER_MESSAGE);
    }

    public void printBallAndStrikeCount(Map<String, Integer> ballAndStrikeCount) {
        Integer ballCount = ballAndStrikeCount.get(BALL_KEY);
        Integer strikeCount = ballAndStrikeCount.get(STRIKE_KEY);

        if (containsOnlyBall(ballCount, strikeCount)) {
            System.out.println(ballCount + BALL);
            return;
        }

        if (containsOnlyStrike(ballCount, strikeCount)) {
            System.out.println(strikeCount + STRIKE);
            return;
        }

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING);
            return;
        }

        System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
    }

    private boolean containsOnlyStrike(Integer ballCount, Integer strikeCount) {
        return 0 < strikeCount && strikeCount <= DIGITS_FOR_THIS_GAME && ballCount == 0;
    }

    private boolean containsOnlyBall(Integer ballCount, Integer strikeCount) {
        return 0 < ballCount && ballCount <= DIGITS_FOR_THIS_GAME && strikeCount == 0;
    }

    public void printCorrectAnswerMessage() {
        System.out.print(CORRECT_ANSWER_MESSAGE);
    }

    public void printRestartMessage() {
        System.out.println(RESTART_GAME_MESSAGE);
    }
}
