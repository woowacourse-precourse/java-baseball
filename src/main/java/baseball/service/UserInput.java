package baseball.service;

import baseball.utils.ConsoleLog;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.validation.ErrorMessage.*;
import static baseball.validation.InputValidation.*;

public class UserInput {
    private static final ConsoleLog consoleLog = ConsoleLog.getInstance();

    public UserInput() {
    }

    public static List<Integer> number(String message) {
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

    private static List<Integer> inputToList(String inputNum) {
        return Stream.of(inputNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
