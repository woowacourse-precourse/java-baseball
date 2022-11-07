package baseball.util;

public enum CharacterUtil {
    SPACE(" "),
    ENTER("\n"),
    NO_SPACE("");

    private final String unit;

    CharacterUtil(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
