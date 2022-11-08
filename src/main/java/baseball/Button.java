package baseball;

import java.util.regex.Pattern;

public class Button {
    private static final Pattern BUTTON = Pattern.compile("^[1-2]$");
    public static final String RE_START = "1";
    private final String button;

    public Button(String button) {
        wrong(button);
        this.button = button;
    }

    public boolean reStart() {
        return button.matches(RE_START);
    }

    private void wrong(String restart) {
        if (!BUTTON.matcher(restart).matches()) {
            throw new BallInputException("1과 2이외의 문자가 들어왔습니다.");
        }
    }
}
