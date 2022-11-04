package baseball.model.domain;

import java.util.List;

import static baseball.model.Constant.*;

public class HintDto {
    private List<Integer> hint;

    public HintDto() {}

    public List<Integer> getHint() {
        return hint;
    }

    public void setHint(List<Integer> hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append(combine(hint.get(BALL_INDEX), BALL_MESSAGE));
        string.append(combine(hint.get(STRIKE_INDEX), STRIKE_MESSAGE));
        if (string.toString().isEmpty()) {
            return NOTHING_MESSAGE;
        }
        return string.toString();
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
