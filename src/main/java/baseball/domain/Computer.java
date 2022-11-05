package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Computer {
    private final static int STRIKE = 0;
    private final static int BALL = 1;

    private HintGenerator hintGenerator;

    public void setStrikeNumbers() {
        ArrayList<Integer> strikeNumbers = new StrikeNumbersGenerator().generateStrikeNumbers();
        this.hintGenerator = new HintGenerator(strikeNumbers);
    }

    public int provideHint(ArrayList<Integer> playerGuess) {
        HashMap<Integer, Integer> hint = hintGenerator.generateHint(playerGuess);
        int strikeCount = hint.get(STRIKE);
        Output.printResult(hint.get(BALL), strikeCount);

        return strikeCount;
    }
}
