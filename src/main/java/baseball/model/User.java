package baseball.model;

import baseball.GameConstants;
import baseball.util.InputValueValidation;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final InputValueValidation inputValueValidation = new InputValueValidation();
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void hitTheBall() {
        String numbersValue = Console.readLine().strip();
        validateNumberValue(numbersValue);
        numbers = toListInteger(numbersValue);
    }

    public boolean isReplayGame() {
        int isReplayValue = Integer.parseInt(Console.readLine().strip());
        validateReplayValue(isReplayValue);
        return isReplayValue == GameConstants.GAME_START;
    }

    public void validateNumberValue(String numbers) {
        if (!inputValueValidation.isValidNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateReplayValue(int isReplayValue) {
        if (!inputValueValidation.isValidReplay(isReplayValue)) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> toListInteger(String number) {
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
