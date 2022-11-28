package baseball.validation;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidation {


    public void isNumberDigit(String input) {
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidNumberAmount(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void isDuplicateNumber(String input) {
        List<String> duplicateCheck = List.of(input.split(""))
                .stream().distinct().collect(Collectors.toList());
        if (input.length() != duplicateCheck.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidReplayCommand(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

}
