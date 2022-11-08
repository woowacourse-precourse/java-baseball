package baseball.controller;

import java.util.regex.Pattern;

public class Controller {
    public boolean validateInput(String regex, String input) {
        return (Pattern.matches(regex, input));
    }
}
