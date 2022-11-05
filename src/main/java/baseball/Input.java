package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public static List<Integer> number() {
        String input = Console.readLine();
        String[] splitInput = input.split("");
        return Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int oneOrTwo() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
