package baseball.util;

public enum ProcessCode {

    RESTART("1") , FINISH("2");

    private final String value;

    ProcessCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
