package baseball;

public enum ValidRegex {
    //1 또는 2로 이루어진 한 자리 수
    RESTART_REQUEST("^[1-2]$"),
    //1부터 9까지 수로 이루어진 3자리 수
    GUESS_VALUE("^[1-9]{3,3}$");

    private final String regex;

    ValidRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
