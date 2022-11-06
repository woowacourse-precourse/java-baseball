package baseball;

import java.util.HashMap;

public class Hints {

    private final HashMap<Hint, Integer> hints;

    public Hints() {
        hints = new HashMap<>();
        for (Hint hint : Hint.values()) {
            hints.put(hint, 0);
        }
    }

    public void addHint(Hint hint){
        int prevScore = hints.get(hint);
        hints.put(hint, prevScore + 1);
    }

    public int findHintCount(Hint hint) {
        return hints.get(hint);
    }
}
