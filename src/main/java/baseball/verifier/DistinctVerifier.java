package baseball.verifier;

import baseball.utils.ExceptionMessage;
import baseball.utils.Util;

public class DistinctVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkDistinct(input);
    }
    private void checkDistinct(String input) {
        if (Util.hasDuplicatedChar(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DISTINCT);
        }
    }
}
