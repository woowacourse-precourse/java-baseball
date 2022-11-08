package baseball.verifiable;

import static baseball.BaseballConstants.TEN_DECIMAL;

public class InputNumberInRange implements VerifiableInputRule {
    private final char lowerNumber;
    private final char upperNumber;

    public InputNumberInRange(int lowerNumber, int upperNumber) {
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
