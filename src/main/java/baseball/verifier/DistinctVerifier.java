package baseball.verifier;

import baseball.system.ExceptionMessage;
import baseball.utils.StringUtility;

public class DistinctVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkDistinct(input);
    }

    private void checkDistinct(String input) {
        if (StringUtility.hasDuplicatedChar(input)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DISTINCT);
        }
    }
}
