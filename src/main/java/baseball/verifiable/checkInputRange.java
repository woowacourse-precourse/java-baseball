package baseball.verifiable;

public class checkInputRange implements VerifiableRule {
    private final char lowerNum;
    private final char upperNum;

    public checkInputRange(int lowerNum, int upperNum) {
        this.lowerNum = intToChar(lowerNum);
        this.upperNum = intToChar(upperNum);
    }

    private char intToChar(int intNum) {
        return (Character.forDigit(intNum, 10));
    }

    @Override
    public boolean validates(String input) {
        return input.codePoints()
                .allMatch(unitNum -> (unitNum >= lowerNum) && (unitNum <= upperNum));
    }
}
