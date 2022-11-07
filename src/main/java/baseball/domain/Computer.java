package baseball.domain;

import baseball.view.Output;

import java.util.ArrayList;
import java.util.HashMap;

public class Computer {
    private final static int STRIKE = 0;
    private final static int BALL = 1;
    private final static int THREE_STRIKES = 3;

    private HintGenerator hintGenerator;
    private boolean isStruckOut;

    public void setForNewGame() {
        isStruckOut = false;
        ArrayList<Integer> strikeNumbers = new StrikeNumbersGenerator().generateStrikeNumbers();
        hintGenerator = new HintGenerator(strikeNumbers);
    }

    public void provideHintTo(Player player) {
        ArrayList<Integer> playerGuess = player.guessNumbers();
        HashMap<Integer, Integer> hint = hintGenerator.generateHint(playerGuess);
        int strikeCount = hint.get(STRIKE);

        if (strikeCount == THREE_STRIKES) {
            isStruckOut = true;
        }
        Output.printResult(hint.get(BALL), strikeCount);
    }

    public boolean isStruckOut() {
        return isStruckOut;
    }
}
