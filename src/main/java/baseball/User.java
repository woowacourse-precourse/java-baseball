package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Exception.isNotDuplicate;
import static baseball.Exception.isOneToNine;

public class User {
    public List<Integer> input() {
        List<Integer> userNum = new ArrayList<>();
        Message.input();
        String input = Console.readLine();

        return userNum = isCorrectInput(input);
    }

    public List<Integer> isCorrectInput(String input) {
        if (!isValid(input)) {
            throw new IllegalArgumentException();
        }
        return stringToIntegerList(input);
    }

    public boolean isValid(String input) {
        boolean b = input.length() == 3 && isOneToNine(input) && isNotDuplicate(input);
        return b;
    }

    public static List<Integer> stringToIntegerList(String input) {
        return Arrays.asList(input.split(""))
                .stream().map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
