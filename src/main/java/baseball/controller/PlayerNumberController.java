package baseball.controller;

import baseball.model.GameNumberCollection;
import baseball.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PlayerNumberController {

    INSTANCE;

    public static GameNumberCollection getPlayerNumbers() {
        List<Integer> numbers = convertInputToNumbers();
        return new GameNumberCollection(numbers);
    }

    private static List<Integer> convertInputToNumbers() {
        String input = InputView.readPlayerNumber();
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
