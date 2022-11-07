package baseball.domain;

public enum Button {
    Yes("1"),No("2");

    private final String buttonValue;

    Button(String buttonValue) {
        this.buttonValue = buttonValue;
    }

    public String getButtonValue() {
        return buttonValue;
    }
}
