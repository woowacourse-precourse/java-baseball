package baseball.verifiable;

@FunctionalInterface
public interface VerifiableRule {
    boolean validates(int input);
}
