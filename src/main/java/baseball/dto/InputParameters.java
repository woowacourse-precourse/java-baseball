package baseball.dto;

import baseball.BallInputException;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParameters {
    private static final Pattern NOT_WHITE_SPACE = Pattern.compile("^\\S+$");
    private final List<Character> parameters;

    public InputParameters(String input) {
        checkSpace(input);
        this.parameters = convertChar(input);
    }

    private static void checkSpace(String input) {
        if (!NOT_WHITE_SPACE.matcher(input).matches()){
            throw new BallInputException("공백은 입력 받을 수 없습니다.");
        }
    }

    private static List<Character> convertChar(String input) {
        return input.codePoints().mapToObj(i -> (char) i).collect(Collectors.toList());
    }

    public List<Character> getParameters() {
        return parameters;
    }
}
