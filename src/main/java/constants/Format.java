package constants;

public enum Format {
    PLAYER_NUMBER("^[1-9]{3}$"),
    PLAYER_CHOICE("^[1-2]{1}$");

    private final String regex;

    Format(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
