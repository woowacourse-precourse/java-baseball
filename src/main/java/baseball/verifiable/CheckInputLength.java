package baseball.verifiable;

public class CheckInputLength implements VerifiableRule {
    private final int restrictedLength;

    public CheckInputLength(int restrictedLength) {
        this.restrictedLength = restrictedLength;
    }

    @Override
    public boolean validates(String input) {
        return (input.length() == restrictedLength);
    }
}
