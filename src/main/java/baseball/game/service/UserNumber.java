package baseball.game.service;

import baseball.game.constants.Exception;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserNumber {

    public static List<Integer> generate(String userInput) {
        if (!isThreeLength(userInput)) {
            throw new IllegalArgumentException(Exception.NO_THREE_LENGTH);
        }

        if (!isNumber(userInput)) {
            throw new IllegalArgumentException(Exception.NO_NUMBER);
        }

        if(!isDuplicateNumber(userInput)) {
            throw new IllegalArgumentException(Exception.DUPLICATE_NUMBER);
        }

        return Arrays.stream(userInput.split(""))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

    }

    private static boolean isThreeLength(String userInput) {
        return userInput.length() == 3;
    }

    private static boolean isNumber(String userInput) {

        return IntStream.range(0,userInput.length())
                .filter(i -> !Character.isDigit(userInput.charAt(i)))
                .findAny()
                .isEmpty();
    }

    private static boolean isDuplicateNumber(String userInput) {
        Set<String> numberSet = new HashSet<>();

        Arrays.stream(userInput.split(""))
                .map(s -> numberSet.add(s))
                .collect(Collectors.toSet());

        return numberSet.size() == 3;
    }
}
