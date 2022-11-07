package baseball.service;

import baseball.enums.InputValidation;
import baseball.utils.GameConsole;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserInput {
    private static final GameConsole CONSOLE = GameConsole.getInstance();
    private static final int ENTER_NUMBERS = 1;
    private static final int RESTART_OR_STOP = 2;

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
        String input = CONSOLE.input();
        checkValidation(input, ENTER_NUMBERS);
        return inputToList(input);
    }

    public String restartOrStop() {
        String input = CONSOLE.input();
        checkValidation(input, RESTART_OR_STOP);
        return input;
    }

    private List<Integer> inputToList(String inputNum) {
        return Stream.of(inputNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private void checkValidation(String input, int group) {
        Optional<InputValidation> validation = Arrays.stream(InputValidation.values())
                .filter(enumType -> enumType.getGroup().contains(group))
                .filter(enumType -> enumType.validate(input))
                .findFirst();

        if (validation.isPresent())
            throw new IllegalArgumentException(validation.get().message());
    }
}
