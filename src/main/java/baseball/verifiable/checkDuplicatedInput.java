package baseball.verifiable;

import java.util.HashSet;
import java.util.Set;

public class checkDuplicatedInput implements VerifiableRule {
    @Override
    public boolean validates(String input) {
        Set<Integer> checkSet = new HashSet<>();
        return input.codePoints()
                .anyMatch(unitNum -> !(checkSet.add(unitNum)));
    }
}
