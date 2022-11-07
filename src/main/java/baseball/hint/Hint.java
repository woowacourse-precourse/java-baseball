package baseball.hint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.game.GameRule.BASEBALL_MAX_SIZE;
import static baseball.hint.HintType.NOTHING;

public class Hint {
    private final Map<HintType, Integer> hints = new HashMap<>();

    public Hint(List<HintType> hintTypes) {
        hintTypes.forEach(hintType -> hints.put(hintType, hints.getOrDefault(hintType, 0) + 1));
    }

    public int findCountBy(HintType hintType) {
        return hints.getOrDefault(hintType, 0);
    }

    public boolean isExistsFrom(HintType hintType) {
        return hints.getOrDefault(hintType, 0) != 0;
    }

    public boolean isNothing() {
        return hints.getOrDefault(NOTHING, 0) == BASEBALL_MAX_SIZE.getRule();
    }
}
