package baseball.baseball;

public class RandomBaseballGame {
    private final BaseballGame baseballGame;
    private Digits randomDigits;

    public RandomBaseballGame(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void newGame(Digits randomDigits) {
        this.randomDigits = randomDigits;
    }

    public Result match(Digits digits) {
        return baseballGame.match(digits, randomDigits);
    }
}
