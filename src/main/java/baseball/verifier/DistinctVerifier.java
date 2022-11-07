package baseball.verifier;

import baseball.system.ExceptionMessage;
import baseball.utils.Utility;

public class DistinctVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkDistinct(input);
    }
    private void checkDistinct(String input) {
        if (Utility.hasDuplicatedChar(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DISTINCT);
        }
    }
}
