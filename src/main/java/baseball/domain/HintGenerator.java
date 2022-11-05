package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class HintGenerator {
    private final static int STRIKE = 0;
    private final static int BALL = 1;
    private final ArrayList<Integer> strikeNumbers;

    public HintGenerator(ArrayList<Integer> strikeNumbers) {
        this.strikeNumbers = strikeNumbers;
    }

    public HashMap<Integer, Integer> generateHint(ArrayList<Integer> playerGuess) {
        HashMap<Integer, Integer> hint = new HashMap<>();
        int NumberOfStrike = countStrike(playerGuess);
        int NumberOfBall = countStrikeOrBall(playerGuess) - NumberOfStrike;

        hint.put(STRIKE, NumberOfStrike);
        hint.put(BALL, NumberOfBall);

        return hint;
    }

    private int countStrike(ArrayList<Integer> playerGuess) {
        int numberOfStrike = 0;
        int currentIndex = 0;

        for (int strikeNumber : strikeNumbers) {
            if (strikeNumber == playerGuess.get(currentIndex)) {
                numberOfStrike++;
            }
            currentIndex++;
        }

        return numberOfStrike;
    }

    private int countStrikeOrBall(ArrayList<Integer> playerGuess) {
        long NumberOfStrikeOrBall = playerGuess.stream()
                .filter(strikeNumbers::contains)
                .count();

        return (int)NumberOfStrikeOrBall;
    }
}
