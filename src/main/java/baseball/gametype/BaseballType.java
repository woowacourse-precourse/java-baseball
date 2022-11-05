package baseball.gametype;

public enum BaseballType {
    THREE_DIGITS(3),
    FOUR_DIGITS(4),
    Five_DIGITS(5);

    BaseballType(int numberOfDigit){
        this.numberOfDigit = numberOfDigit;
    }

    private int numberOfDigit;

    public int getNumberOfDigit() {
        return numberOfDigit;
    }

    public boolean isFormatCorrect(){
        return true;
    }
}
