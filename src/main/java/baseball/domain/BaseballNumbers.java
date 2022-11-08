package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private final char ZERO_CHARACTER = '0';
    List<Integer> numbers;

    public BaseballNumbers(String playerGuess) {
        this.numbers = string2List(playerGuess);
    }

    private List<Integer> string2List(String playerGuess) {
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<playerGuess.length(); i++) {
            numbers.add(playerGuess.charAt(i) - ZERO_CHARACTER);
        }

        return numbers;
    }
}
