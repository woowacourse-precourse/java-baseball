package baseball.service;

import baseball.utils.ConsoleLog;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.validation.InputValidation.*;

public class UserInput {
    private static final ConsoleLog consoleLog = ConsoleLog.getInstance();

    public UserInput() {
    }

    public static List<Integer> number(String message) {
        consoleLog.print(message);
        String inputNum = consoleLog.input();

        if (inputNum.isBlank())
            throw new IllegalArgumentException("아무것도_입력하지_않았습니다.");
        if (!isThreeLength(inputNum))
            throw new IllegalArgumentException("세_자리가_아닙니다.");
        if (!isNumber(inputNum))
            throw new IllegalArgumentException("숫자가_아니거나_0이_포함되어_있습니다.");
        if (isDuplicate(inputNum))
            throw new IllegalArgumentException("중복된_숫자가_포함되어_있습니다.");

        return inputToList(inputNum);
    }

    private static List<Integer> inputToList(String inputNum) {
        return Stream.of(inputNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
