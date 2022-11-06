package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_MAX_RANGE = 3;
    private static final String NUMBER_SEPARATE_DELIMITER = "";
    private static final String NUMBER_RANGE = "^[1-9]*$";
    private static final String YES_OR_NO_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public static List<Integer> getInput() {
        System.out.print(GET_NUMBER_MESSAGE);

        String numbers = Console.readLine();
        validate(numbers);

        return toInteger(numbers);
    }

    private static void validate(String input) {
        if (!Pattern.matches(NUMBER_RANGE, input)) {
            throw new IllegalArgumentException();
        }
        if (input.length() != NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException();
        }
        String[] numbers = separate(input);
        Set<String> ballNums = new HashSet<>(Arrays.asList(numbers));

        if (ballNums.size() != numbers.length) {
            throw new IllegalArgumentException();
        }

    }

    private static List<Integer> toInteger(String numbers) {
        return Arrays.stream(separate(numbers))
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }


    private static String[] separate(String input) {
        return input.split(NUMBER_SEPARATE_DELIMITER);
    }

    public static boolean yesOrNo() {
        System.out.println(YES_OR_NO_MESSAGE);

        String input = Console.readLine();
        validateInput(input);
        return input.equals("1");
    }

    private static void validateInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}