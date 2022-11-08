package baseball;

public class GuessValidator {

    public void validateGuess(String guess) {
        if (!this.isLengthThree(guess) || !this.isOnlyNumber(guess)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isOnlyNumber(String guess) {
        return guess.matches("^[0-9]*$");
    }

    private boolean isLengthThree(String guess) {
        return guess.length() == 3;
    }
}
