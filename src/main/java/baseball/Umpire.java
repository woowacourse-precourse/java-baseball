package baseball;

import constants.Rule;
import constants.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Umpire {
    private final Rule hint = Rule.HINT;
    private Map<Text, Integer> hintRecord;

    public Umpire() {
        hintRecord = new HashMap<>();
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
}
