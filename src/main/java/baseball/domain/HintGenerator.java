package baseball.domain;

import java.util.ArrayList;

public class HintGenerator {
    private final ArrayList<Integer> strikeNumbers;

    public HintGenerator(ArrayList<Integer> strikeNumbers) {
        this.strikeNumbers = strikeNumbers;
    }

    private int countStrike(ArrayList<Integer> playerGuess) {
        int numberOfStrikes = 0;
        int currentIndex = 0;

        for (int strikeNumber : strikeNumbers) {
            if (strikeNumber == playerGuess.get(currentIndex)) {
                numberOfStrikes++;
            }
            currentIndex++;
        }

        return numberOfStrikes;
    }

}
