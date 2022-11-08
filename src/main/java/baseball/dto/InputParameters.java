package baseball.dto;

import baseball.BallInputException;
import baseball.model.BallNumbers;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParameters {
    private static final Pattern BLANK_FILTER = Pattern.compile("^\\S+$");
    private static final Pattern NOT_NUMBER = Pattern.compile("^\\D+$");
    private final BallNumbers parameters;

    public InputParameters(String input) {
        checkSpace(input);
        checkWord(input);
        this.parameters = new BallNumbers(convertChar(input));
    }

    private static void checkSpace(String input) {
        if (!BLANK_FILTER.matcher(input).matches()) {
            throw new BallInputException("공백은 허용되지 않습니다.");
        }
    }

    private static void checkWord(String input) {
        if (NOT_NUMBER.matcher(input).matches()) {
            throw new BallInputException("공백은 허용되지 않습니다.");
        }
    }

    private static List<Character> convertChar(String input) {
        return input.codePoints().mapToObj(i -> (char) i).collect(Collectors.toList());
    }

    public BallNumbers hits() {
        return parameters;
    }
}
