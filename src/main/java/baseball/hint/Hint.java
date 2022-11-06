package baseball.hint;

import java.util.List;

public class Hint {
    private List<HintType> hints;

    public Hint(List<HintType> hints) {
        this.hints = hints;
    }

    public List<HintType> getHints() {
        return hints;
    }
}
