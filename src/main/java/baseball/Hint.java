package baseball;

import java.util.List;
import java.util.function.Function;

public enum Hint {
    BALL(i -> String.format("%d볼", i)),
    STRIKE(i -> String.format("%d스트라이크", i)),
    NOTHING(i -> new String("낫싱"));

    private Function<Long, String> hintStringExpression;

    Hint(Function<Long, String> hintString) {
        this.hintStringExpression = hintString;
    }

    public String hintString(Long i) {
        if (i != 0) {
            return hintStringExpression.apply(i);
        }
        return "";
    }
}
