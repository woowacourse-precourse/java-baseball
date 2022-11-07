package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Input {

    public static List<Integer> number() {
        String input = Console.readLine();
        validateNumberInput(input);
        String[] splitInput = input.split("");
        return Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int oneOrTwo() {
        String input = Console.readLine();
        validateOneOrTwoInput(input);
        return Integer.parseInt(input);
    }

    public static void validateNumberInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        Set<Integer> numberSet = new HashSet<>();
        String[] splitInput = input.split("");
        for (String number : splitInput) {
            if (number.charAt(0) < '1' || number.charAt(0) > '9') {
                throw new IllegalArgumentException();
            }
            numberSet.add(Integer.parseInt(number));
        }
        if (numberSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateOneOrTwoInput(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) < '1' || input.charAt(0) > '2') {
            throw new IllegalArgumentException();
        }
    }
}
