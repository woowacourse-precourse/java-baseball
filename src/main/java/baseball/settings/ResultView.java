package baseball.settings;

import static baseball.settings.Constants.*;

import java.util.List;

public class ResultView {
    private static Integer ballCount;
    private static Integer strikeCount;

    public static void printOut(List<Integer> scores) {
        ballCount = scores.get(BALL_INDEX);
        strikeCount = scores.get(STRIKE_INDEX);

        StringBuilder message = new StringBuilder();
        message.append(getBallMessage());
        message.append(getSpace());
        message.append(getStrikeMessage());
        message.append(getNothingMessage());

        System.out.println(message);
    }

    public static String getBallMessage() {
        if (ballCount != 0) {
            return ballCount + BALL_MESSAGE; // "1볼"
        }
        return NO_SPACE; // ""
    }

    public static String getSpace() {
        if (ballCount != 0 && strikeCount != 0) {
            return SPACE_BETWEEN_WORDS; // " "
        }
        return NO_SPACE;
    }

    public static String getStrikeMessage() {
        if (strikeCount != 0) {
            return strikeCount + STRIKE_MESSAGE; // "1스트라이크"
        }
        return NO_SPACE;
    }

    public static String getNothingMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING_MESSAGE;
        }
        return NO_SPACE;
    }
}
