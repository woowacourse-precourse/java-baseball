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
                .filter(digit -> computerNumber.stream().anyMatch(digit::equals))
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
}
