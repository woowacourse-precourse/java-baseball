package baseball.verifiable;

@FunctionalInterface
public interface VerifiableInputRule {
    boolean validates(String input);
}
