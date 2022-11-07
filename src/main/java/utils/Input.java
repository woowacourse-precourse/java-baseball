package utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public static List<Integer> playerNumber() {
        String input = Console.readLine();
        return Arrays.stream(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
