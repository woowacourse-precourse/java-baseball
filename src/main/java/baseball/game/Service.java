package baseball.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static baseball.util.Constant.*;

public class Service {
    public static String printHint(List<Integer> hint) {
        StringBuilder string = new StringBuilder();

        string.append(combine(hint.get(BALL_INDEX), BALL_MESSAGE));
        string.append(combine(hint.get(STRIKE_INDEX), STRIKE_MESSAGE));
        if (string.toString().isEmpty()) {
            return NOTHING_MESSAGE;
        }
        return string.toString();
    }

    private static String combine(int value, String message) {
        StringBuilder string = new StringBuilder();

        if (value > 0) {
            string.append(value)
                    .append(message);
            if (message.equals(BALL_MESSAGE)) {
                string.append(BLANK);
            }
        }
        return string.toString();
    }

    public static List<Integer> countHint(List<Integer> userNumber, List<Integer> computerNumber) {
        List<Integer> hint = new ArrayList<>();
        hint.add(countBall(userNumber, computerNumber));
        hint.add(countStrike(userNumber, computerNumber));
        return hint;
    }

    public static int countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        int count = 0;

        if (!Objects.equals(userNumber.get(0), computerNumber.get(0))
                && (Objects.equals(userNumber.get(0), computerNumber.get(1))
                || Objects.equals(userNumber.get(0), computerNumber.get(2)))) {
            count++;
        }
        if (!Objects.equals(userNumber.get(1), computerNumber.get(1))
                && (Objects.equals(userNumber.get(1), computerNumber.get(2))
                || Objects.equals(userNumber.get(1), computerNumber.get(0)))) {
            count++;
        }
        if (!Objects.equals(userNumber.get(2), computerNumber.get(2))
                && (Objects.equals(userNumber.get(2), computerNumber.get(0))
                || Objects.equals(userNumber.get(2), computerNumber.get(1)))) {
            count++;
        }
        return count;
    }

    public static int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int count = 0;

        if (Objects.equals(userNumber.get(0), computerNumber.get(0))) {
            count++;
        }
        if (Objects.equals(userNumber.get(1), computerNumber.get(1))) {
            count++;
        }
        if (Objects.equals(userNumber.get(2), computerNumber.get(2))) {
            count++;
        }
        return count;
    }

    public static boolean isThreeStrike(List<Integer> hint) {
        return hint.equals(THREE_STRIKE);
    }
}
