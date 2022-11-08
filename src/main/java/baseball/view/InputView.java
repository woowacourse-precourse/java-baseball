package baseball.view;

import baseball.view.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NUMBER_SEPARATE_DELIMITER = "";
    private static final String YES_OR_NO_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String YES = "1";

    public static List<Integer> getInput() {
        System.out.print(GET_NUMBER_MESSAGE);
        String numbers = Console.readLine();
        InputValidator.validate(numbers);
        return toInteger(numbers);
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

        String choice = Console.readLine();
        InputValidator.validateUserChoice(choice);
        return choice.equals(YES);
    }
}