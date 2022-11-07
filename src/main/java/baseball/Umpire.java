package baseball;

import constants.Rule;
import constants.Text;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Umpire {
    private final Rule hint = Rule.HINT;
    private Map<Text, Integer> hintRecord;

    public Umpire() {
        hintRecord = new EnumMap<>(Text.class);
    }

    private boolean isNothing(List<Integer> computerNumber, List<Integer> playerNumber) {
        return ((int) playerNumber.stream()
                .filter(computerNumber::contains)
                .count()) == hint.getMin();
    }

    private void resetHintRecord() {
        hintRecord.put(Text.BALL, hint.getMin());
        hintRecord.put(Text.STRIKE, hint.getMin());
    }

    private void countStrike(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = (int) IntStream.range(hint.getMin(), hint.getMax())
                .filter(index -> playerNumber.get(index).equals(computerNumber.get(index)))
                .count();

        hintRecord.put(Text.STRIKE, strike);
    }

    private void countBall(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ball = (int) playerNumber.stream()
                .filter(computerNumber::contains)
                .filter(digit -> playerNumber.indexOf(digit) != computerNumber.indexOf(digit))
                .count();

        hintRecord.put(Text.BALL, ball);
    }

    public Map<Text, Integer> compareNumber(List<Integer> computerNumber, List<Integer> playerNumber) {
        resetHintRecord();

        if (isNothing(computerNumber, playerNumber)) {
            return null;
        }

        countStrike(computerNumber, playerNumber);
        countBall(computerNumber, playerNumber);

        return hintRecord;
    }

    public boolean isPlayerWin() {
        return hintRecord.get(Text.STRIKE) == hint.getMax();
    }

}
