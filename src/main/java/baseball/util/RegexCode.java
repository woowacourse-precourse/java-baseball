package baseball.util;

public enum RegexCode {

    REGEX_NOT_NUMBER("[^\\d]"),
    REGEX_HAS_DUPLICATE_VALUE("(\\w)\\1+");

    private final String regex;

    public String getRegex() {
        return this.regex;
    }

    RegexCode(String regex) {
        this.regex = regex;
    }
}
