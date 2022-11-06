package baseball.dto;

import baseball.BallInputException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParameters {
    private static final Pattern checkInput = Pattern.compile("^(?=.*\\d)(?!.*([0-9])(?!.*([0-9])).{0,3}$)");
    private final List<Character> parameters;

    public InputParameters(String input) {
        checkSpace(input);
        this.parameters = convertChar(input);
    }

    private static void checkSpace(String input) {
        if (!checkInput.matcher(input).matches()){
            throw new BallInputException("중복된 숫자, 공백,");
        }
    }

    private static List<Character> convertChar(String input) {
        return input.codePoints().mapToObj(i -> (char) i).collect(Collectors.toList());
    }

    public List<Character> getParameters() {
        return parameters;
    }
}
