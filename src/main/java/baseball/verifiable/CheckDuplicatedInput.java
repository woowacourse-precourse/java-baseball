package baseball.verifiable;

import java.util.HashSet;
import java.util.Set;

public class CheckDuplicatedInput implements VerifiableRule {
    @Override
    public boolean validates(String input) {
        Set<Integer> checkNumber = new HashSet<>();
        return input.codePoints()
                .allMatch(checkNumber::add);
    }
}
