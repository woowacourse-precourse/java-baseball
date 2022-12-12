package baseball.dto;

import baseball.model.Hint;

import java.util.HashMap;

public class Hints {

    private final HashMap<Hint, Integer> hints;

    public Hints() {
        hints = new HashMap<>();
        for (Hint hint : Hint.values()) {
            hints.put(hint, 0);
        }
    }

    public void addHint(Hint hint) {
        Integer prevScore = hints.get(hint); // 스코어도 감싸야할까?
        hints.put(hint, prevScore + 1);
    }

    public int getScore(Hint hint) {
        return hints.get(hint);
    }

    public HashMap<Hint, Integer> getHints() {
        return hints;
    }
}
