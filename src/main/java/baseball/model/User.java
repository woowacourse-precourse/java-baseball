package baseball.model;

import baseball.GameState;
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

        if (!inputValueValidation.isValidNumber(numbersValue)) {
            throw new IllegalArgumentException();
        }

        numbers = toListInteger(numbersValue);
    }

    private List<Integer> toListInteger(String number) {
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean isReplayGame() {
        int isReplayValue = Integer.parseInt(Console.readLine().strip());

        if (!inputValueValidation.isValidReplay(isReplayValue)) {
            throw new IllegalArgumentException();
        }

        return isReplayValue == GameState.START.ordinal();
    }
}
