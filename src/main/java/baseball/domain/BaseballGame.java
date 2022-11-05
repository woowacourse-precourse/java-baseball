package baseball.domain;

public class BaseballGame {

    private final Numbers numbers;

    public BaseballGame(Numbers numbers) {
        this.numbers = numbers;
    }

    public Hints result(Numbers numbers) {
        return this.numbers.match(numbers);
    }

    public boolean isEnd(Hints hints) {
        return hints.count(Hint.STRIKE) == 3;
    }
}
