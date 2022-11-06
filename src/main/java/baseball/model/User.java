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
        String inputValue = Console.readLine().strip();

        if (!inputValueValidation.isValid(inputValue)) {
            throw new IllegalArgumentException();
        }

        numbers = toListInteger(inputValue);
    }

    private List<Integer> toListInteger(String number) {
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean isReplayGame() {
        int isReplay = Integer.parseInt(Console.readLine().strip());
        return isReplay == GameState.START.ordinal();
    }
}
