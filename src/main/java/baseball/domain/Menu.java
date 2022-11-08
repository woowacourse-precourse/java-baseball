package baseball.domain;

public class Menu {
    private static final String RESTART = "1";
    private static final String END = "2";

    private String value;

    private Menu() {
    }

    public Menu(String value) {
        validate(value);
        this.value = value;
    }

    public boolean chooseRestart() {
        return value.equals(RESTART);
    }

    private void validate(String value) {
        if (!value.equals(RESTART) && !value.equals(END)) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }
}
