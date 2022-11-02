package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleLog {
    private ConsoleLog() {
    }

    public static void print(String message) {
        System.out.print(message);
    };

    public static void println(String message) {
        System.out.println(message);
    };

    public static List<Integer> input(String message) throws IllegalArgumentException {
        print(message);
        String inputNum = Console.readLine();

        if (inputNum.isBlank())
            throw new IllegalArgumentException("아무것도_입력하지_않았습니다.");
        if (!isValidateLength(inputNum))
            throw new IllegalArgumentException("세_자리가_아닙니다.");
        if (!isValidateLetterAndLength(inputNum))
            throw new IllegalArgumentException("숫자가_아니거나_0이_포함되어_있습니다.");
        if (isDuplicateNumber(inputNum))
            throw new IllegalArgumentException("중복된_숫자가_포함되어_있습니다.");

        return inputToList(inputNum);
    }

    private static List<Integer> inputToList(String inputNum) {
        return Stream.of(inputNum.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isValidateLength (String inputNum) {
        return inputNum.length() == 3;
    }

    private static boolean isValidateLetterAndLength (String inputNum) {
        return inputNum.matches("^[1-9][1-9][1-9]$");
    }

    private static boolean isDuplicateNumber (String inputNum) {
        return inputNum.matches("^.*(.)\\1.*$");
    }
}
