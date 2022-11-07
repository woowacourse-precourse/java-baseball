package baseball.baesball;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.exception.BaseballException.BASEBALL_SIZE_EXCEPTION;
import static baseball.game.GameRule.BASEBALL_MAX_SIZE;

public class Baseball {
    private final List<Integer> baseballs;

    public Baseball(List<Integer> baseballs) {
        if (validateBaseballSizeNotOk(baseballs)) {
            throw new IllegalArgumentException(BASEBALL_SIZE_EXCEPTION.getMessage());
        }
        this.baseballs = baseballs;
    }

    private boolean validateBaseballSizeNotOk(List<Integer> baseballs) {
        List<Integer> distinctBaseball = baseballs.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        return distinctBaseball.size() != BASEBALL_MAX_SIZE.getRule();
    }

    public List<Integer> getBaseballs() {
        return baseballs;
    }
}
