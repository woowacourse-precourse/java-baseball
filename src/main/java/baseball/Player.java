package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    public List<Integer> askNumbers() {
        String userInput = Console.readLine();
        return parseUserNumbersToList(userInput);
    }

    public List<Integer> parseUserNumbersToList(String userAnswer) {
        List<Integer> parsedAnswer = new ArrayList<>();

        if (userAnswer.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            Arrays.stream(userAnswer.split(""))
                    .forEach((num) -> parsedAnswer.add(Integer.parseInt(num)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return parsedAnswer;
    }
}
