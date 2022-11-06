package baseball.util;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {

    public Input() {
    }

    public static List<String> inputNumber() {
        String userAnswerInput = Console.readLine();
        List<String> inputNumberList = new ArrayList<>();
        for (int i = 0; i < userAnswerInput.length(); i++) {
            inputNumberList.add(String.valueOf(userAnswerInput.charAt(i)));
        }
        isValidNumber(inputNumberList);
        return inputNumberList;
    }

    private static void isValidNumber(List<String> inputNumberList) {
        if (inputNumberList.size() == 3) {
            Set<String> listSet = new HashSet<>(inputNumberList);
            if (listSet.size() != 3) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String inputReplayAnswer() {
        String userReplayAnswer = Console.readLine();
        isValidReplayNumber(userReplayAnswer);
        return userReplayAnswer;
    }

    private static void isValidReplayNumber(String inputNumber) {

        if (!inputNumber.matches("[12]")) {
            throw new IllegalArgumentException();
        }

    }

}
