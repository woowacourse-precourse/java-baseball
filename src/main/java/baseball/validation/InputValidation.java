package baseball.validation;

import baseball.service.GameSetting;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.service.GameCommand.*;

public class InputValidation {

    public void isNumberDigit(String input) {
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidNumberAmount(String input) {
        if (input.length() != GameSetting.GAME_END_CONDITION.getAttribute()) {
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
        if (!input.equals(RETRY.getCommand()) && !input.equals(QUIT.getCommand())) {
            throw new IllegalArgumentException();
        }
    }

}
