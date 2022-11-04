package baseball.verifiable;

public class checkInputLength implements VerifiableRule {
    private final int restrictedLength;

    public checkInputLength(int restrictedLength) {
        this.restrictedLength = restrictedLength;
    }

    @Override
    public boolean validates(String input) {
        return (input.length() == restrictedLength);
    }
}
