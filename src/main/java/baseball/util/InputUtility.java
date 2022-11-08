package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputUtility {

    public static String readLine(int type) {
        String input = Console.readLine();
        validationTest(input, type);
        return input;
    }

    public static List<Integer> parsingNumber(String input) {
        return Stream.of(input.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }


    private static void validationTest(String input, int type) {

        if (type == GameCode.ATTACK.getValue()) {
            isValidAttack(input);
        }

        if (type == GameCode.CONTINUE.getValue()) {
            isValidProcess(input);
        }

    }

    private static void isValidProcess(String input) {
        List<String> validProcess = Arrays.asList("1", "2");
        if (!validProcess.contains(input)) {
            throw new IllegalArgumentException("유효하지 않은 문자입니다.");
        }
    }

    private static void isValidAttack(String input) {
        if (!isNaturalNumber(input)) {
            throw new IllegalArgumentException("1-9 이외의 문자가 들어있습니다. 1-9까지의 숫자만 입력해주세요");
        }

        if (isOutOfIndex(input)) {
            throw new IllegalArgumentException("입력값이 많거나 적습니다. 숫자 3개를 입력해주세요");
        }

        if (isDuplicated(input)) {
            throw new IllegalArgumentException("중복된 문자가 들어있습니다.");
        }

    }

    private static boolean isDuplicated(String input) {
        String deduplicatedInput = String.join("", new HashSet<>(List.of(input.split(""))));
        return deduplicatedInput.length() != input.length();
    }

    private static boolean isNaturalNumber(String input) {
        return input.matches("[1-9]+");
    }

    private static boolean isOutOfIndex(String input) {
        return input.length() != 3;
    }

}
