package baseball.view;

import baseball.utils.InputValidator;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private InputView() {

    }

    public static List<Integer> readUserNumbers() throws IllegalArgumentException {
        String input = Console.readLine();
        InputValidator.isLengthThree(input);
        InputValidator.isAllNumber(input);
        return stringToList(input);
    }

    public static int readGameCommand() throws IllegalArgumentException {
        String input = Console.readLine();
        InputValidator.isOneOrTwo(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> stringToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add((int) input.charAt(i) - '0');
        }
        return numbers;
    }
}
