package baseball.model.game;

import baseball.model.number.NumberCollection;

public class Game {
    private final NumberCollection computerNumbers;

    public Game(NumberCollection computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public GameResult getResultOf(NumberCollection playerNumbers) {
        int ballCnt = computerNumbers.countBalls(playerNumbers);
        int strikeCnt = computerNumbers.countStrikes(playerNumbers);

        return new GameResult(ballCnt, strikeCnt);
    }

}
