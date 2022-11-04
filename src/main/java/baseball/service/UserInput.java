package baseball.service;

import baseball.utils.ConsoleLog;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.enums.ErrorMessage.*;
import static baseball.validation.InputValidation.*;

public class UserInput {
    private static final ConsoleLog consoleLog = ConsoleLog.getInstance();

    private UserInput() {
    }

    private static class LazyHolder {
        private static final UserInput INSTANCE = new UserInput();
    }

    public static UserInput getInstance() {
        return LazyHolder.INSTANCE;
    }

    public List<Integer> number(String message) {
        consoleLog.print(message);
        String inputNum = consoleLog.input();

        if (inputNum.isBlank())
            throw new IllegalArgumentException(IS_BLANK.message());
        if (!isThreeLength(inputNum))
            throw new IllegalArgumentException(IS_NOT_THREE_LENGTH.message());
        if (!isNumber(inputNum))
            throw new IllegalArgumentException(IS_NOT_NUMBER_OR_CONTAINS_0.message());
        if (isDuplicate(inputNum))
            throw new IllegalArgumentException(IS_DUPLICATE.message());

        return inputToList(inputNum);
    }

    private List<Integer> inputToList(String inputNum) {
        return Stream.of(inputNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
