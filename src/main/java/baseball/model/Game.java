package baseball.model;

public class Game {

    private final BaseballNumber computer;

    public Game() {
        this.computer = new BaseballNumber();
    }

    public PlayResult playGame(BaseballNumber baseballNumber) {
        int strike = computer.getStrike(baseballNumber);
        int ball = computer.getBall(baseballNumber);

        return new PlayResult(strike, ball);
    }
}
