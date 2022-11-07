package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Guess {
    ArrayList<Integer> numberList;

    public Guess(String input) {
        checkValidityOfGuess(input);
        numberList = parseStringIntoInteger(input);
    }

    static ArrayList<Integer> parseStringIntoInteger(String input) {
        int guessIntFormat = Integer.parseInt(input);
        ArrayList<Integer> parsed = new ArrayList<>();

        for (int divisor = 100; divisor != 0; guessIntFormat %= divisor, divisor /= 10) {
            parsed.add(guessIntFormat / divisor);
        }
        return parsed;
    }

    static void checkValidityOfGuess(String input) throws IllegalArgumentException {
        Integer guessIntFormat = Integer.parseInt(input);
        ArrayList<Integer> guessParsed = parseStringIntoInteger(input);
        Set<Integer> uniqueElementOnly;

        if (guessIntFormat < 123 || guessIntFormat > 987) {
            throw new IllegalArgumentException("범위를 준수하지 않았습니다.");
        }

        if (input.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 수로만 이루어져야 합니다.");
        }

        uniqueElementOnly = new HashSet<>(guessParsed);
        if (uniqueElementOnly.size() != input.length()) {
            throw new IllegalArgumentException("숫자의 중복이 있습니다.");
        }
    }
}
