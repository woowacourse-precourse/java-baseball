package baseball;

import java.util.regex.Pattern;

public enum Valid {
    NOT_INPUT_NUMBER(Pattern.compile("[^1-9]")),
    NOT_RESTART_NUMBER(Pattern.compile("[^1-2]"));

    private final Pattern pattern;

    Valid(Pattern pattern) {
        this.pattern = pattern;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
