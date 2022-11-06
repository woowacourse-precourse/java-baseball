package baseball.baesball;

import java.text.MessageFormat;
import java.util.List;

import static baseball.exception.BaseballException.BASEBALL_SIZE_EXCEPTION;
import static baseball.referee.GameRule.BASEBALL_MAX_SIZE;

public class Baseball {
    private final List<Integer> baseballs;

    public Baseball(List<Integer> baseballs) {
        if (validateBaseballSizeNotOk(baseballs)) {
            throw new IllegalArgumentException(
                    MessageFormat.format(BASEBALL_SIZE_EXCEPTION.getMessage(), baseballs.size()));
        }
        this.baseballs = baseballs;
    }

    private static boolean validateBaseballSizeNotOk(List<Integer> baseballs) {
        return baseballs.size() != BASEBALL_MAX_SIZE.getRule();
    }

    public List<Integer> getBaseballs() {
        return baseballs;
    }
}
