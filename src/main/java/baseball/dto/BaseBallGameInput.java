package baseball.dto;

public class BaseBallGameInput {
    private String randomNumber;
    private String guessNumber;

    public BaseBallGameInput(String randomNumber, String guessNumber) {
        this.randomNumber = randomNumber;
        this.guessNumber = guessNumber;
    }

    public String getGuessNumber() {
        return guessNumber;
    }

    public String getRandomNumber() {
        return randomNumber;
    }
}
