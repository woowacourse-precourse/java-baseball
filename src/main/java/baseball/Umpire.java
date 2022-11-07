package baseball;

import constants.Rule;

import java.util.List;

public class Umpire {
    private final Rule hint = Rule.HINT;

    private boolean isNothing(List<Integer> computerNumber, List<Integer> playerNumber) {
        return ((int) playerNumber.stream()
                .filter(digit -> computerNumber.stream().anyMatch(digit::equals))
                .count()) == hint.getMin();
    }

}
