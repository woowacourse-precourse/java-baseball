package baseball.verifiable;

public class InputNumberEqualLength implements VerifiableInputRule {
    private final int restrictedLength;

    public InputNumberEqualLength(int restrictedLength) {
        this.restrictedLength = restrictedLength;
    }

    @Override
    public boolean validates(String input) {
        return (input.length() == restrictedLength);
    }
}
