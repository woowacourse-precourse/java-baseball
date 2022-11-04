package baseball.verifier;

@FunctionalInterface
public interface MakeVerifier {
    void checkValid(String input);
}
