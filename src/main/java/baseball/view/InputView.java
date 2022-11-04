package baseball.view;

import baseball.model.Balls;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static Balls input(String input) {
        Pattern pattern = Pattern.compile("^[1-9]{3}$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
        return asBalls(Integer.parseInt(input));
    }

    private static Balls asBalls(int num) {

    }
}
