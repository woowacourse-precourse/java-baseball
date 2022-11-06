package baseball.verifier;

import java.util.Arrays;
import java.util.List;

public class GameVerifier {
    private static final List<Verifier> verifiers = Arrays.asList(
            new NumberVerifier(),
            new DistinctVerifier()
    );

    public static void check(String input) {
        verifiers.forEach(verifier -> verifier.check(input));
    }
}
