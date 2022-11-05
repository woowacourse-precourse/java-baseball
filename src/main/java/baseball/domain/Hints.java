package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Hints {

    private final List<Hint> hints;

    public Hints(List<Hint> hints) {
        this.hints = hints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hints hints1 = (Hints) o;
        return Objects.equals(hints, hints1.hints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hints);
    }
}
