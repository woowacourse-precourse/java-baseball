package baseball.verifiable;

public class CheckInputRange implements VerifiableRule {
    private final static int TEN_DECIMAL = 10;
    private final char lowerNumber;
    private final char upperNumber;

    public CheckInputRange(int lowerNumber, int upperNumber) {
        this.lowerNumber = intToChar(lowerNumber);
        this.upperNumber = intToChar(upperNumber);
    }

    private char intToChar(int intNumber) {
        return (Character.forDigit(intNumber, TEN_DECIMAL));
    }

    @Override
    public boolean validates(String input) {
        return input.codePoints()
                .allMatch(unitNum -> (unitNum >= lowerNumber) && (unitNum <= upperNumber));
    }
}
