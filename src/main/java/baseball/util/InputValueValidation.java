package baseball.util;

import baseball.GameConstants;
import java.util.Arrays;
import java.util.List;

public class InputValueValidation {

    public boolean isValidReplay(int replayValue) {
        return replayValue == GameConstants.GAME_START || replayValue == GameConstants.GAME_END;
    }

    public boolean isValidNumber(String numbersValue) {
        return isNumber(numbersValue) && isLengthThree(numbersValue) && noDuplicates(numbersValue);
    }

    public boolean isNumber(String inputValue) {
        return inputValue.chars()
                .allMatch(num -> num >= (GameConstants.NUMBER_MIN + '0') && num <= (GameConstants.NUMBER_MAX + '0'));
    }

    public boolean isLengthThree(String inputValue) {
        return inputValue.length() == GameConstants.NUMBER_LENGTH;
    }

    public boolean noDuplicates(String inputValue) {
        List<String> arrayInputValue = Arrays.asList(inputValue.split(""));
        return arrayInputValue.stream().distinct().count() == GameConstants.NUMBER_LENGTH;
    }
}
