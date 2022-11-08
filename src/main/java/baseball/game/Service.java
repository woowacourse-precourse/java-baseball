package baseball.game;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static baseball.util.Constant.*;

public class Service {

    public Service() {}

    public List<Integer> calculateHint(List<Integer> userNumber, List<Integer> computerNumber) {
        return Arrays.asList(
                calculateBall(userNumber, computerNumber),
                calculateStrike(userNumber, computerNumber));
    }

    public int calculateBall(List<Integer> userNumber, List<Integer> computerNumber) {
        int count = 0;

        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (!Objects.equals(userNumber.get(index), computerNumber.get(index))
                    && (Objects.equals(userNumber.get(index), computerNumber.get((index + 1) % 3))
                    || Objects.equals(userNumber.get(index), computerNumber.get((index + 2) % 3)))) {
                count++;
            }
        }
        return count;
    }

    public static int calculateStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int count = 0;

        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (Objects.equals(userNumber.get(index), computerNumber.get(index))) {
                count++;
            }
        }
        return count;
    }

    public String hintToString(List<Integer> hint) {
        StringBuilder string = new StringBuilder();

        string.append(combine(hint.get(BALL_INDEX), BALL_MESSAGE))
                .append(combine(hint.get(STRIKE_INDEX), STRIKE_MESSAGE));
        if (string.toString().isEmpty()) {
            return NOTHING_MESSAGE + NEWLINE;
        }
        return string
                .append(NEWLINE)
                .toString();
    }

    private String combine(int value, String message) {
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
}
