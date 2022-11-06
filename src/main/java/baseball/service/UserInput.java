package baseball.service;

import baseball.utils.GameConsole;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.enums.ErrorMessage.*;
import static baseball.validation.InputValidation.*;

public class UserInput {
    private static final GameConsole CONSOLE = GameConsole.getInstance();

    private UserInput() {
    }

    private static class LazyHolder {
        private static final UserInput INSTANCE = new UserInput();
    }

    public static UserInput getInstance() {
        return LazyHolder.INSTANCE;
    }

    public List<Integer> enterNumbers(String message) {
        CONSOLE.print(message);
        String inputNum = CONSOLE.input();
        if (inputNum.isBlank())
            throw new IllegalArgumentException(BLANK_INPUT.message());
        if (!isThreeLength(inputNum))
            throw new IllegalArgumentException(NOT_THREE_LENGTH.message());
        if (!isNumber(inputNum))
            throw new IllegalArgumentException(NOT_NUMBER_OR_CONTAINS_0.message());
        if (isDuplicated(inputNum))
            throw new IllegalArgumentException(DUPLICATED.message());
        return inputToList(inputNum);
    }

    public String restartOrStop() {
        String input = CONSOLE.input();
        if (input.isBlank())
            throw new IllegalArgumentException(BLANK_INPUT.message());
        if (!isOneOrTwo(input))
            throw new IllegalArgumentException(NOT_ONE_OR_TWO.message());
        return input;
    }

    private List<Integer> inputToList(String inputNum) {
        return Stream.of(inputNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
