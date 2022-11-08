package baseball.util;


import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    public static List<String> inputNumber() {
        List<String> inputNumberList = List.of(Console.readLine().split(""));
        isValidNumber(inputNumberList);
        return inputNumberList;
    }

    private static void isValidNumber(List<String> inputNumberList) {
        Set<String> listSet = new HashSet<>(inputNumberList);
        if (listSet.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static String inputReplayAnswer() {
        String userReplayAnswer = Console.readLine();
        isValidReplayNumber(userReplayAnswer);
        return userReplayAnswer;
    }

    private static void isValidReplayNumber(String inputNumber) {
        if (!inputNumber.equals("1") && !inputNumber.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

}
